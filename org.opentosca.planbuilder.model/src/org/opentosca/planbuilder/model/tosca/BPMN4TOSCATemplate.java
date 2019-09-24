package org.opentosca.planbuilder.model.tosca;

public class BPMN4TOSCATemplate {

	private String[] connection;
	private String id;;
	private Parameter[] input;
	private String name;
	private String nodeInterface;
	private String nodeOperation;
	private String nodeTemplate;
	private Parameter[] output;
	private Position position;
	private Template template;
	private String type;
	private String instanceType;

	public String[] getConnection() {
		return connection;
	}

	public String getId() {
		return id;
	}

	public Parameter[] getInput() {
		return input;
	}

	public String getName() {
		return name;
	}

	public String getNodeInterface() {
		return nodeInterface;
	}

	public String getNodeOperation() {
		return nodeOperation;
	}

	public String getNodeTemplate() {
		return nodeTemplate;
	}

	public Parameter[] getOutput() {
		return output;
	}

	public Position getPosition() {
		return position;
	}

	public Template getTemplate() {
		return template;
	}

	public String getType() {
		return type;
	}

	public String getInstanceType() {
		return instanceType;
	}

}

class Position {
	private int left;
	private int top;

	public int getLeft() {
		return left;
	}

	public int getTop() {
		return top;
	}
}

class Template {
	private String id;
	private String namespace;
	private String type;
	private String nodeInterface;
	private String operation;

	public String getId() {
		return id;
	}

	public String getNamespace() {
		return namespace;
	}

	public String getType() {
		return type;
	}

	public String getNodeInterface() {
		return nodeInterface;
	}

	public String getOperation() {
		return operation;
	}
}

class Parameter {
	private String name;
	private String type;
	private String required;
	private String value;

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getRequired() {
		return required;
	}

	public String getValue() {
		return value;
	}
}