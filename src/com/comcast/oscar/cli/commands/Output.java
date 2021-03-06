package com.comcast.oscar.cli.commands;

import java.io.File;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;

/**
 * 
 * @author Allen Flickinger (allen.flickinger@gmail.com)
 * 
 * @bannerLicense
	Copyright 2015 Comcast Cable Communications Management, LLC<br>
	___________________________________________________________________<br>
	Licensed under the Apache License, Version 2.0 (the "License")<br>
	you may not use this file except in compliance with the License.<br>
	You may obtain a copy of the License at<br>
	http://www.apache.org/licenses/LICENSE-2.0<br>
	Unless required by applicable law or agreed to in writing, software<br>
	distributed under the License is distributed on an "AS IS" BASIS,<br>
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>
	See the License for the specific language governing permissions and<br>
	limitations under the License.<br>

 */

public class Output {
	
	public static final String ERROR = "Output file not found. Please use -o <filename> to specify an output file.";
	
	private final String[] args;
	private File fOutput;
	
	/**
	 * Get Output arguments
	 * @param args
	 */
	public Output(String[] args) {
		this.args = args;
	}
	
	/**
	 * Set option parameters for command Output
	 * @return Option
	 */
	public static final Option OptionParameters() {
		OptionBuilder.withArgName("filename");
		OptionBuilder.hasArgs(1);
        OptionBuilder.withValueSeparator(' ');
        OptionBuilder.withLongOpt("output");
        OptionBuilder.withDescription("Compile the input file to this output file.");      
    	return OptionBuilder.create("o");
	}
	
	/**
	 * Return Output file
	 * @return File
	 */
	public File getOutput() {
		this.fOutput = new File(this.args[0]);
		
		if (this.fOutput.getParentFile() != null) {
			this.fOutput.getParentFile().mkdirs();
		}
		
		return this.fOutput;
	}
	
}
