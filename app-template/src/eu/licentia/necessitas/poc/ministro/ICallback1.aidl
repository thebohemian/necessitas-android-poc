package eu.licentia.necessitas.poc.ministro;

import eu.licentia.necessitas.poc.ministro.IResult;

interface ICallback1
{
		String getApplicationName();
		
		int getRequiredLoaderLevel();
		
		void finished(IResult result);

}
