package eu.licentia.necessitas.poc.ministro;

import java.util.List;

interface IResult {

	boolean isSuccess();

	String getLoaderPath();

	String getLoaderClassName();

	List<String> getSharedLibraries();

	String getBridgeLocation();

	String getBridgeInitializerClassName();

}
