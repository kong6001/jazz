package com.elex_project.sphinx;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class OSSProject {
	@JsonProperty("project")
	private String project;
	@JsonProperty("description")
	private String description;
	@JsonProperty("version")
	private String version;
	@JsonProperty("developers")
	private String[] developers;
	@JsonProperty("url")
	private String url;
	@JsonProperty("year")
	private String year;
	@JsonProperty("licenses")
	private License[] licenses;
	@JsonProperty("dependency")
	private String dependency;

	@Data
	@Setter(AccessLevel.PRIVATE)
	@NoArgsConstructor
	public static class License {
		@JsonProperty("license")
		private String license;
		@JsonProperty("license_url")
		private String licenseUrl;
	}

	/**
	 * Read OSS Project info from input stream
	 *
	 * use with
	 * {@code
	 * id("com.jaredsburrows.license") version "0.8.90"
	 * }
	 *
	 * @param inputStream is
	 * @return OSSProject[]
	 * @throws IOException e
	 */
	public static OSSProject[] read(final InputStream inputStream) throws IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(inputStream, OSSProject[].class);
	}
}