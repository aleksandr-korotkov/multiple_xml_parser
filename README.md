# multiple_xml_parser
Multiple maven project. Homework build tools

1.	Separate your last homework (XML, JSON) to API (interfaces,pojos) and Implementation. Those will be 2 different projects. Organize them in one multi-module project.
2.	Use maven shade plugin to create uber jar.
3.	Create 2 maven profiles – production and qa. Use different input XML files for them. Store path to XML file in some properties file as variable, specify real path via pom.xml.
4.	Add some dependency used only for unit testing (no need to write tests for now)
