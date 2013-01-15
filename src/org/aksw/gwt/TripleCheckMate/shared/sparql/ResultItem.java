/*******************************************************************************
 * Copyright 2013 Agile Knowledge Engineering and Semantic Web (AKSW) Group
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.aksw.gwt.TripleCheckMate.shared.sparql;

import java.io.Serializable;

public class ResultItem implements Serializable{
	/**
	 * Autogenerated for serialization
	 */
	private static final long serialVersionUID = -2067749804344339633L;
	public String value = "";
	public String type = "";
	public String lang = "";
	public String datatype = "";
	public ResultItem(){}
	public ResultItem(String v, String t, String l, String d){
		value = v;
		type = t;
		lang = l;
		datatype = d;
	}
	
	public String toString(){
		if (type.equalsIgnoreCase("literal"))
			return "\"" + value + "\" (@lang = "+ lang + ")";
		if (type.equalsIgnoreCase("typed-literal"))
			return "\"" + value + "\" (@type = "+ datatype + ")";
		return value;
	}
	public String toHTMLString(){
		if (type.equalsIgnoreCase("uri"))
			return "<a href=\""+dereferenceURI(value) + "\" title=\""+value + "\" target=\"_blank\">"+ abbreviateURI(value) + "</a>";
		if (type.equalsIgnoreCase("literal"))
			return "\"" + value + "\" (@lang = "+ lang + ")";
		if (type.equalsIgnoreCase("typed-literal"))
			return "\"" + value + "\" (@type = "+ datatype + ")";
		return value;
	}
	private String abbreviateURI(String uri){
		return PrefixService.getAbbeviatedForm(uri);
	}
	private String dereferenceURI(String uri){
		return uri.replace("http://dbpedia.org/", "http://dbpedia.aksw.org:8877/");
	}
}
