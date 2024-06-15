package com.chtrembl.petstore.product.model;

import ch.qos.logback.core.joran.spi.JoranException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

@SuppressWarnings("serial")
public class ContainerEnvironment implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(ContainerEnvironment.class);
	private String containerHostName = null;
	private String appVersion = null;
	private String appDate = null;
	private String year = null;

	@PostConstruct
	private void initialize() throws JoranException {

		try {
			this.setContainerHostName(
					InetAddress.getLocalHost().getHostAddress() + "/" + InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			this.setContainerHostName("unknown");
		}

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Version version = objectMapper.readValue(new ClassPathResource("version.json").getFile(), Version.class);
			this.setAppVersion(version.getVersion());
			this.setAppDate(version.getDate());
		} catch (IOException e) {
			logger.info("error parsing file " + e.getMessage());
			this.setAppVersion("unknown");
			this.setAppDate("unknown");
		}

		this.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
	}

	public String getContainerHostName() {
		return containerHostName;
	}

	public void setContainerHostName(String containerHostName) {
		this.containerHostName = containerHostName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
