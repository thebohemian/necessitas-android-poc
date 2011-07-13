
package eu.licentia.necessitas.poc.ministro;

import eu.licentia.necessitas.poc.ministro.ICallback1;

interface IMinistroService
{
	boolean checkCompatibility(int ministroLevel);
	
	void serve(in ICallback1 callback); 
}
