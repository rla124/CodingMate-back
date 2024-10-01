package com.creativesemester.SejongCodingMate.domain.code.service;

import com.creativesemester.SejongCodingMate.global.response.ErrorType;
import com.creativesemester.SejongCodingMate.global.response.SuccessType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CompilerServiceV2 {
	private static final long TIMEOUT_SECONDS = 10;
	private static final String PYTHON_EXECUTOR = "python3";

	public Object[] runCode(String executeCode, String input, String answer) {
		Path tempFile = null;
		try {
			tempFile = Files.createTempFile("main", ".py");
			Files.write(tempFile, executeCode.getBytes());

			ProcessBuilder processBuilder = new ProcessBuilder(PYTHON_EXECUTOR, tempFile.toString())
				.redirectInput(ProcessBuilder.Redirect.PIPE)
				.redirectOutput(ProcessBuilder.Redirect.PIPE);

			Process process = processBuilder.start();

			if (input != null && !input.isEmpty()) {
				try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
					writer.write(input);
				}
			}

			if (!process.waitFor(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
				process.destroy();
				return new Object[]{SuccessType.CODE_TIMEOUT, null};
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				StringBuilder output = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					output.append(line).append("\n");
				}
				String codeExecuteAnswer = output.toString().trim();

				if (codeExecuteAnswer.equals(answer)) {
					return new Object[]{SuccessType.CODE_ACCEPT, codeExecuteAnswer};
				} else {
					return new Object[]{SuccessType.CODE_WRONG_ANSWER, codeExecuteAnswer};
				}
			}

		} catch (IOException e) {
			return new Object[]{ErrorType.CODE_EXCEPTION, e.getMessage()};
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return new Object[]{ErrorType.CODE_EXCEPTION, e.getMessage()};
		} finally {
			if (tempFile != null) {
				try {
					Files.deleteIfExists(tempFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
