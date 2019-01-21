package com.klykoo.jScrapr;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
	public final static String VERSION = "0.1";

	public static void main(String[] args) {
		Options options = new Options();
		String header = "Scraping webpages on command line\n\n";

		options.addOption("help", false, "Print this help");
		options.addOption("v", false, "Version " + VERSION);
		options.addOption(Option.builder("u").argName("url").longOpt("URL").desc("URL to scrap").hasArg(true).build());
		

		String footer = "\nPlease report issues at contact@klykoo.com";
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
			String token = cmd.getOptionValue("token");
			if (token == null || token.isEmpty()) {
				token = cmd.getOptionValue("init");
			}
			String chan = cmd.getOptionValue("c");
			if (cmd.hasOption("v")) {
				System.out.println("Version " + VERSION);		
			} else {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("jScrapr", header, options, footer, true);
			}

		} catch (ParseException e) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("jScrapr", header, options, footer, true);
		}
	}

}
