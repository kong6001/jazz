/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
	@AllArgsConstructor
	public static class License {
		@JsonProperty("license")
		private String license;
		@JsonProperty("license_url")
		private String licenseUrl;

	}

	public OSSProject(final String title, final String developer,
	                  final String version, final String license, final String licenseUrl) {
		this();
		this.project = title;
		this.developers = new String[]{developer};
		this.version = version;
		this.licenses = new License[]{
				new License(license, licenseUrl)
		};

	}

	/**
	 * Read OSS Project info from input stream
	 * <p>
	 * use with
	 * {@code
	 * id("com.jaredsburrows.license") version "0.8.90"
	 * }
	 *
	 * @param inputStream is
	 * @return OSSProject[]
	 * @throws IOException e
	 */
	public static @NotNull List<OSSProject> readAsList(final @NotNull InputStream inputStream) throws IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(inputStream,
				objectMapper.getTypeFactory()
						.constructCollectionType(List.class, OSSProject.class));
	}

	public static OSSProject[] read(final @NotNull InputStream inputStream) throws IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(inputStream, OSSProject[].class);
	}
}
