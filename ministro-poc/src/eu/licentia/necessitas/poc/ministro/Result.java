package eu.licentia.necessitas.poc.ministro;

import java.util.List;

public final class Result extends IResult.Stub {
	boolean success;
	String loaderPath;
	String loaderClassName;
	List<String> sharedLibraries;
	String bridgeLocation;
	String bridgeInitializerClassName;

	public boolean isSuccess() {
		return success;
	}

	public String getLoaderPath() {
		return loaderPath;
	}

	public String getLoaderClassName() {
		return loaderClassName;
	}

	public List<String> getSharedLibraries() {
		return sharedLibraries;
	}

	public String getBridgeLocation() {
		return bridgeLocation;
	}

	public String getBridgeInitializerClassName() {
		return bridgeInitializerClassName;
	}

}
