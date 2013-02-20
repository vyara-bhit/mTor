/**
 * MessageServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package nl.bhit.mtor.client.wsdl;

/*
 *  MessageServiceStub java implementation
 */

public class MessageServiceStub extends org.apache.axis2.client.Stub {
	protected org.apache.axis2.description.AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private final java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private final java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private final java.util.HashMap faultMessageMap = new java.util.HashMap();

	private static int counter = 0;

	private static synchronized java.lang.String getUniqueSuffix() {
		// reset the counter if it is greater than 99999
		if (counter > 99999) {
			counter = 0;
		}
		counter = counter + 1;
		return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {

		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("MessageService" + getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[2];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "getMessagesWithTimestamp"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "saveSoapMessage"));
		_service.addOperation(__operation);

		_operations[1] = __operation;

	}

	// populates the faults
	private void populateFaults() {

	}

	/**
	 * Constructor that takes in a configContext
	 */

	public MessageServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext, java.lang.String targetEndpoint)
			throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public MessageServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext, java.lang.String targetEndpoint, boolean useSeparateListener)
			throws org.apache.axis2.AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

		_serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

	}

	/**
	 * Default Constructor
	 */
	public MessageServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

		this(configurationContext, "http://localhost:8080/services/MessageService");

	}

	/**
	 * Default Constructor
	 */
	public MessageServiceStub() throws org.apache.axis2.AxisFault {

		this("http://localhost:8080/services/MessageService");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public MessageServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see nl.bhit.mTor.client.wsdl.MessageService#getMessagesWithTimestamp
	 * @param getMessagesWithTimestamp0
	 */

	public nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE getMessagesWithTimestamp(

	nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE getMessagesWithTimestamp0)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction("http://service.mtor.bhit.nl/MessageManager/getMessagesWithTimestamp");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getMessagesWithTimestamp0,
					optimizeContent(new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "getMessagesWithTimestamp")), new javax.xml.namespace.QName(
							"http://service.mtor.bhit.nl/", "getMessagesWithTimestamp"));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
					nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE.class, getEnvelopeNamespaces(_returnEnv));

			return (nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getMessagesWithTimestamp"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(), "getMessagesWithTimestamp"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
								"getMessagesWithTimestamp"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see nl.bhit.mTor.client.wsdl.MessageService#startgetMessagesWithTimestamp
	 * @param getMessagesWithTimestamp0
	 */
	public void startgetMessagesWithTimestamp(

	nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE getMessagesWithTimestamp0,

	final nl.bhit.mtor.client.wsdl.MessageServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction("http://service.mtor.bhit.nl/MessageManager/getMessagesWithTimestamp");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getMessagesWithTimestamp0,
				optimizeContent(new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "getMessagesWithTimestamp")), new javax.xml.namespace.QName(
						"http://service.mtor.bhit.nl/", "getMessagesWithTimestamp"));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			@Override
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
							nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE.class, getEnvelopeNamespaces(resultEnv));
					callback.receiveResultgetMessagesWithTimestamp((nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE) object);

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorgetMessagesWithTimestamp(e);
				}
			}

			@Override
			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getMessagesWithTimestamp"))) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
										.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getMessagesWithTimestamp"));
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
								java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
								// message class
								java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt
										.getQName(), "getMessagesWithTimestamp"));
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								callback.receiveErrorgetMessagesWithTimestamp(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetMessagesWithTimestamp(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetMessagesWithTimestamp(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetMessagesWithTimestamp(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetMessagesWithTimestamp(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetMessagesWithTimestamp(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetMessagesWithTimestamp(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgetMessagesWithTimestamp(f);
							}
						} else {
							callback.receiveErrorgetMessagesWithTimestamp(f);
						}
					} else {
						callback.receiveErrorgetMessagesWithTimestamp(f);
					}
				} else {
					callback.receiveErrorgetMessagesWithTimestamp(error);
				}
			}

			@Override
			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			@Override
			public void onComplete() {
				try {
					_messageContext.getTransportOut().getSender().cleanup(_messageContext);
				} catch (org.apache.axis2.AxisFault axisFault) {
					callback.receiveErrorgetMessagesWithTimestamp(axisFault);
				}
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see nl.bhit.mTor.client.wsdl.MessageService#saveSoapMessage
	 * @param saveSoapMessage2
	 */

	public nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE saveSoapMessage(

	nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE saveSoapMessage2)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction("saveSoapMessage");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), saveSoapMessage2, optimizeContent(new javax.xml.namespace.QName(
					"http://service.mtor.bhit.nl/", "saveSoapMessage")), new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "saveSoapMessage"));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
					nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE.class, getEnvelopeNamespaces(_returnEnv));

			return (nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "saveSoapMessage"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(), "saveSoapMessage"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
								"saveSoapMessage"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see nl.bhit.mTor.client.wsdl.MessageService#startsaveSoapMessage
	 * @param saveSoapMessage2
	 */
	public void startsaveSoapMessage(

	nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE saveSoapMessage2,

	final nl.bhit.mtor.client.wsdl.MessageServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction("saveSoapMessage");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), saveSoapMessage2, optimizeContent(new javax.xml.namespace.QName(
				"http://service.mtor.bhit.nl/", "saveSoapMessage")), new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "saveSoapMessage"));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			@Override
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
							nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE.class, getEnvelopeNamespaces(resultEnv));
					callback.receiveResultsaveSoapMessage((nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE) object);

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorsaveSoapMessage(e);
				}
			}

			@Override
			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "saveSoapMessage"))) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
										.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "saveSoapMessage"));
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
								java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
								// message class
								java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt
										.getQName(), "saveSoapMessage"));
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								callback.receiveErrorsaveSoapMessage(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorsaveSoapMessage(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorsaveSoapMessage(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorsaveSoapMessage(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorsaveSoapMessage(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorsaveSoapMessage(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorsaveSoapMessage(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorsaveSoapMessage(f);
							}
						} else {
							callback.receiveErrorsaveSoapMessage(f);
						}
					} else {
						callback.receiveErrorsaveSoapMessage(f);
					}
				} else {
					callback.receiveErrorsaveSoapMessage(error);
				}
			}

			@Override
			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			@Override
			public void onComplete() {
				try {
					_messageContext.getTransportOut().getSender().cleanup(_messageContext);
				} catch (org.apache.axis2.AxisFault axisFault) {
					callback.receiveErrorsaveSoapMessage(axisFault);
				}
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[1].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private final javax.xml.namespace.QName[] opNameArray = null;

	private boolean optimizeContent(javax.xml.namespace.QName opName) {

		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}
		return false;
	}

	// http://localhost:8080/services/MessageService
	public static class Address extends BaseObject implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = address
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Address
		 */

		protected java.lang.String localAddress;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localAddressTracker = false;

		public boolean isAddressSpecified() {
			return localAddressTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAddress() {
			return localAddress;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Address
		 */
		public void setAddress(java.lang.String param) {
			localAddressTracker = param != null;

			this.localAddress = param;

		}

		/**
		 * field for City
		 */

		protected java.lang.String localCity;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localCityTracker = false;

		public boolean isCitySpecified() {
			return localCityTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCity() {
			return localCity;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            City
		 */
		public void setCity(java.lang.String param) {
			localCityTracker = param != null;

			this.localCity = param;

		}

		/**
		 * field for Country
		 */

		protected java.lang.String localCountry;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localCountryTracker = false;

		public boolean isCountrySpecified() {
			return localCountryTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCountry() {
			return localCountry;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Country
		 */
		public void setCountry(java.lang.String param) {
			localCountryTracker = param != null;

			this.localCountry = param;

		}

		/**
		 * field for PostalCode
		 */

		protected java.lang.String localPostalCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localPostalCodeTracker = false;

		public boolean isPostalCodeSpecified() {
			return localPostalCodeTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getPostalCode() {
			return localPostalCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PostalCode
		 */
		public void setPostalCode(java.lang.String param) {
			localPostalCodeTracker = param != null;

			this.localPostalCode = param;

		}

		/**
		 * field for Province
		 */

		protected java.lang.String localProvince;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localProvinceTracker = false;

		public boolean isProvinceSpecified() {
			return localProvinceTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getProvince() {
			return localProvince;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Province
		 */
		public void setProvince(java.lang.String param) {
			localProvinceTracker = param != null;

			this.localProvince = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":address", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "address", xmlWriter);
			}

			if (localAddressTracker) {
				namespace = "";
				writeStartElement(null, namespace, "address", xmlWriter);

				if (localAddress == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAddress);

				}

				xmlWriter.writeEndElement();
			}
			if (localCityTracker) {
				namespace = "";
				writeStartElement(null, namespace, "city", xmlWriter);

				if (localCity == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("city cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCity);

				}

				xmlWriter.writeEndElement();
			}
			if (localCountryTracker) {
				namespace = "";
				writeStartElement(null, namespace, "country", xmlWriter);

				if (localCountry == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("country cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCountry);

				}

				xmlWriter.writeEndElement();
			}
			if (localPostalCodeTracker) {
				namespace = "";
				writeStartElement(null, namespace, "postalCode", xmlWriter);

				if (localPostalCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("postalCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localPostalCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localProvinceTracker) {
				namespace = "";
				writeStartElement(null, namespace, "province", xmlWriter);

				if (localProvince == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("province cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localProvince);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance", "type"));
			attribList.add(new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "address"));
			if (localAddressTracker) {
				elementList.add(new javax.xml.namespace.QName("", "address"));

				if (localAddress != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddress));
				} else {
					throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
				}
			}
			if (localCityTracker) {
				elementList.add(new javax.xml.namespace.QName("", "city"));

				if (localCity != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCity));
				} else {
					throw new org.apache.axis2.databinding.ADBException("city cannot be null!!");
				}
			}
			if (localCountryTracker) {
				elementList.add(new javax.xml.namespace.QName("", "country"));

				if (localCountry != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCountry));
				} else {
					throw new org.apache.axis2.databinding.ADBException("country cannot be null!!");
				}
			}
			if (localPostalCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("", "postalCode"));

				if (localPostalCode != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPostalCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException("postalCode cannot be null!!");
				}
			}
			if (localProvinceTracker) {
				elementList.add(new javax.xml.namespace.QName("", "province"));

				if (localProvince != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProvince));
				} else {
					throw new org.apache.axis2.databinding.ADBException("province cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Address parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Address object = new Address();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"address".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (Address) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "address").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "address" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setAddress(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "city").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "city" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setCity(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "country").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "country" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setCountry(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "postalCode").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "postalCode" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setPostalCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "province").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "province" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setProvince(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class UserE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "user", "ns1");

		/**
		 * field for User
		 */

		protected User localUser;

		/**
		 * Auto generated getter method
		 * 
		 * @return User
		 */
		public User getUser() {
			return localUser;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            User
		 */
		public void setUser(User param) {

			this.localUser = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it

			if (localUser == null) {
				throw new org.apache.axis2.databinding.ADBException("user cannot be null!");
			}
			localUser.serialize(MY_QNAME, xmlWriter);

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it
			return localUser.getPullParser(MY_QNAME);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static UserE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				UserE object = new UserE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement() && new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "user").equals(reader.getName())) {

								object.setUser(User.Factory.parse(reader));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetMessagesWithTimestamp implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = getMessagesWithTimestamp
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Arg0
		 */

		protected MTorMessage localArg0;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localArg0Tracker = false;

		public boolean isArg0Specified() {
			return localArg0Tracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return MTorMessage
		 */
		public MTorMessage getArg0() {
			return localArg0;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Arg0
		 */
		public void setArg0(MTorMessage param) {
			localArg0Tracker = param != null;

			this.localArg0 = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":getMessagesWithTimestamp", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "getMessagesWithTimestamp", xmlWriter);
				}

			}
			if (localArg0Tracker) {
				if (localArg0 == null) {
					throw new org.apache.axis2.databinding.ADBException("arg0 cannot be null!!");
				}
				localArg0.serialize(new javax.xml.namespace.QName("", "arg0"), xmlWriter);
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localArg0Tracker) {
				elementList.add(new javax.xml.namespace.QName("", "arg0"));

				if (localArg0 == null) {
					throw new org.apache.axis2.databinding.ADBException("arg0 cannot be null!!");
				}
				elementList.add(localArg0);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static GetMessagesWithTimestamp parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetMessagesWithTimestamp object = new GetMessagesWithTimestamp();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"getMessagesWithTimestamp".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (GetMessagesWithTimestamp) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "arg0").equals(reader.getName())) {

						object.setArg0(MTorMessage.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetMessagesWithTimestampResponseE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://service.mtor.bhit.nl/",
				"getMessagesWithTimestampResponse", "ns1");

		/**
		 * field for GetMessagesWithTimestampResponse
		 */

		protected GetMessagesWithTimestampResponse localGetMessagesWithTimestampResponse;

		/**
		 * Auto generated getter method
		 * 
		 * @return GetMessagesWithTimestampResponse
		 */
		public GetMessagesWithTimestampResponse getGetMessagesWithTimestampResponse() {
			return localGetMessagesWithTimestampResponse;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            GetMessagesWithTimestampResponse
		 */
		public void setGetMessagesWithTimestampResponse(GetMessagesWithTimestampResponse param) {

			this.localGetMessagesWithTimestampResponse = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it

			if (localGetMessagesWithTimestampResponse == null) {
				throw new org.apache.axis2.databinding.ADBException("getMessagesWithTimestampResponse cannot be null!");
			}
			localGetMessagesWithTimestampResponse.serialize(MY_QNAME, xmlWriter);

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it
			return localGetMessagesWithTimestampResponse.getPullParser(MY_QNAME);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static GetMessagesWithTimestampResponseE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetMessagesWithTimestampResponseE object = new GetMessagesWithTimestampResponseE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "getMessagesWithTimestampResponse").equals(reader
											.getName())) {

								object.setGetMessagesWithTimestampResponse(GetMessagesWithTimestampResponse.Factory.parse(reader));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Status implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "status", "ns1");

		/**
		 * field for Status
		 */

		protected java.lang.String localStatus;

		private static java.util.HashMap _table_ = new java.util.HashMap();

		// Constructor

		protected Status(java.lang.String value, boolean isRegisterValue) {
			localStatus = value;
			if (isRegisterValue) {

				_table_.put(localStatus, this);

			}

		}

		public static final java.lang.String _INFO = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("INFO");

		public static final java.lang.String _WARN = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("WARN");

		public static final java.lang.String _ERROR = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ERROR");

		public static final Status INFO = new Status(_INFO, true);

		public static final Status WARN = new Status(_WARN, true);

		public static final Status ERROR = new Status(_ERROR, true);

		public java.lang.String getValue() {
			return localStatus;
		}

		@Override
		public boolean equals(java.lang.Object obj) {
			return (obj == this);
		}

		@Override
		public int hashCode() {
			return toString().hashCode();
		}

		@Override
		public java.lang.String toString() {

			return localStatus.toString();

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it

			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String _localName = parentQName.getLocalPart();

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":status", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "status", xmlWriter);
				}
			}

			if (localStatus == null) {

				throw new org.apache.axis2.databinding.ADBException("status cannot be null !!");

			} else {

				xmlWriter.writeCharacters(localStatus);

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME, new java.lang.Object[] {
					org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatus) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			public static Status fromValue(java.lang.String value) throws java.lang.IllegalArgumentException {
				Status enumeration = (Status)

				_table_.get(value);

				if ((enumeration == null) && !((value == null) || (value.equals("")))) {
					throw new java.lang.IllegalArgumentException();
				}
				return enumeration;
			}

			public static Status fromString(java.lang.String value, java.lang.String namespaceURI) throws java.lang.IllegalArgumentException {
				try {

					return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

				} catch (java.lang.Exception e) {
					throw new java.lang.IllegalArgumentException();
				}
			}

			public static Status fromString(javax.xml.stream.XMLStreamReader xmlStreamReader, java.lang.String content) {
				if (content.indexOf(":") > -1) {
					java.lang.String prefix = content.substring(0, content.indexOf(":"));
					java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
					return Status.Factory.fromString(content, namespaceUri);
				} else {
					return Status.Factory.fromString(content, "");
				}
			}

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Status parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Status object = null;
				// initialize a hash map to keep values
				java.util.Map attributeMap = new java.util.HashMap();
				java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {

							nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
							if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
								throw new org.apache.axis2.databinding.ADBException("The element: " + "status" + "  cannot be null");
							}

							java.lang.String content = reader.getElementText();

							if (content.indexOf(":") > 0) {
								// this seems to be a Qname so find the namespace and send
								prefix = content.substring(0, content.indexOf(":"));
								namespaceuri = reader.getNamespaceURI(prefix);
								object = Status.Factory.fromString(content, namespaceuri);
							} else {
								// this seems to be not a qname send and empty namespace incase of it is
								// check is done in fromString method
								object = Status.Factory.fromString(content, "");
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class SaveSoapMessageResponse implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = saveSoapMessageResponse
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":saveSoapMessageResponse", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "saveSoapMessageResponse", xmlWriter);
				}

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static SaveSoapMessageResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SaveSoapMessageResponse object = new SaveSoapMessageResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"saveSoapMessageResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (SaveSoapMessageResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class BaseObject implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = baseObject
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":baseObject", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "baseObject", xmlWriter);
				}

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static BaseObject parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				BaseObject object = null;

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"baseObject".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (BaseObject) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

							throw new org.apache.axis2.databinding.ADBException("The an abstract class can not be instantiated !!!");

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Company implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = company
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Id
		 */

		protected long localId;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localIdTracker = false;

		public boolean isIdSpecified() {
			return localIdTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return long
		 */
		public long getId() {
			return localId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Id
		 */
		public void setId(long param) {

			// setting primitive attribute tracker to true
			localIdTracker = param != java.lang.Long.MIN_VALUE;

			this.localId = param;

		}

		/**
		 * field for Name
		 */

		protected java.lang.String localName;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localNameTracker = false;

		public boolean isNameSpecified() {
			return localNameTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getName() {
			return localName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Name
		 */
		public void setName(java.lang.String param) {
			localNameTracker = param != null;

			this.localName = param;

		}

		/**
		 * field for Projects
		 * This was an Array!
		 */

		protected Project[] localProjects;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localProjectsTracker = false;

		public boolean isProjectsSpecified() {
			return localProjectsTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Project[]
		 */
		public Project[] getProjects() {
			return localProjects;
		}

		/**
		 * validate the array for Projects
		 */
		protected void validateProjects(Project[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Projects
		 */
		public void setProjects(Project[] param) {

			validateProjects(param);

			localProjectsTracker = true;

			this.localProjects = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            Project
		 */
		public void addProjects(Project param) {
			if (localProjects == null) {
				localProjects = new Project[] {};
			}

			// update the setting tracker
			localProjectsTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localProjects);
			list.add(param);
			this.localProjects = (Project[]) list.toArray(new Project[list.size()]);

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":company", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "company", xmlWriter);
				}

			}
			if (localIdTracker) {
				namespace = "";
				writeStartElement(null, namespace, "id", xmlWriter);

				if (localId == java.lang.Long.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
				}

				xmlWriter.writeEndElement();
			}
			if (localNameTracker) {
				namespace = "";
				writeStartElement(null, namespace, "name", xmlWriter);

				if (localName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localName);

				}

				xmlWriter.writeEndElement();
			}
			if (localProjectsTracker) {
				if (localProjects != null) {
					for (int i = 0; i < localProjects.length; i++) {
						if (localProjects[i] != null) {
							localProjects[i].serialize(new javax.xml.namespace.QName("", "projects"), xmlWriter);
						} else {

							writeStartElement(null, "", "projects", xmlWriter);

							// write the nil attribute
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					writeStartElement(null, "", "projects", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "id"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
			}
			if (localNameTracker) {
				elementList.add(new javax.xml.namespace.QName("", "name"));

				if (localName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
				}
			}
			if (localProjectsTracker) {
				if (localProjects != null) {
					for (int i = 0; i < localProjects.length; i++) {

						if (localProjects[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "projects"));
							elementList.add(localProjects[i]);
						} else {

							elementList.add(new javax.xml.namespace.QName("", "projects"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("", "projects"));
					elementList.add(localProjects);

				}

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Company parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Company object = new Company();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"company".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (Company) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list3 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "id").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "id" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setId(org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setId(java.lang.Long.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "name").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "name" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "projects").equals(reader.getName())) {

						// Process the array and step past its final element's end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list3.add(null);
							reader.next();
						} else {
							list3.add(Project.Factory.parse(reader));
						}
						// loop until we find a start element that is not part of this array
						boolean loopDone3 = false;
						while (!loopDone3) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are exiting the xml structure
								loopDone3 = true;
							} else {
								if (new javax.xml.namespace.QName("", "projects").equals(reader.getName())) {

									nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list3.add(null);
										reader.next();
									} else {
										list3.add(Project.Factory.parse(reader));
									}
								} else {
									loopDone3 = true;
								}
							}
						}
						// call the converter utility to convert and set the array

						object.setProjects((Project[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(Project.class, list3));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class SaveSoapMessage implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = saveSoapMessage
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Arg0
		 */

		protected SoapMessage localArg0;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localArg0Tracker = false;

		public boolean isArg0Specified() {
			return localArg0Tracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SoapMessage
		 */
		public SoapMessage getArg0() {
			return localArg0;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Arg0
		 */
		public void setArg0(SoapMessage param) {
			localArg0Tracker = param != null;

			this.localArg0 = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":saveSoapMessage", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "saveSoapMessage", xmlWriter);
				}

			}
			if (localArg0Tracker) {
				if (localArg0 == null) {
					throw new org.apache.axis2.databinding.ADBException("arg0 cannot be null!!");
				}
				localArg0.serialize(new javax.xml.namespace.QName("", "arg0"), xmlWriter);
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localArg0Tracker) {
				elementList.add(new javax.xml.namespace.QName("", "arg0"));

				if (localArg0 == null) {
					throw new org.apache.axis2.databinding.ADBException("arg0 cannot be null!!");
				}
				elementList.add(localArg0);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static SaveSoapMessage parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SaveSoapMessage object = new SaveSoapMessage();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"saveSoapMessage".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (SaveSoapMessage) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "arg0").equals(reader.getName())) {

						object.setArg0(SoapMessage.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Project implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = project
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Company
		 */

		protected Company localCompany;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localCompanyTracker = false;

		public boolean isCompanySpecified() {
			return localCompanyTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Company
		 */
		public Company getCompany() {
			return localCompany;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Company
		 */
		public void setCompany(Company param) {
			localCompanyTracker = param != null;

			this.localCompany = param;

		}

		/**
		 * field for Id
		 */

		protected long localId;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localIdTracker = false;

		public boolean isIdSpecified() {
			return localIdTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return long
		 */
		public long getId() {
			return localId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Id
		 */
		public void setId(long param) {

			// setting primitive attribute tracker to true
			localIdTracker = param != java.lang.Long.MIN_VALUE;

			this.localId = param;

		}

		/**
		 * field for Messages
		 * This was an Array!
		 */

		protected MTorMessage[] localMessages;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localMessagesTracker = false;

		public boolean isMessagesSpecified() {
			return localMessagesTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return MTorMessage[]
		 */
		public MTorMessage[] getMessages() {
			return localMessages;
		}

		/**
		 * validate the array for Messages
		 */
		protected void validateMessages(MTorMessage[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Messages
		 */
		public void setMessages(MTorMessage[] param) {

			validateMessages(param);

			localMessagesTracker = true;

			this.localMessages = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            MTorMessage
		 */
		public void addMessages(MTorMessage param) {
			if (localMessages == null) {
				localMessages = new MTorMessage[] {};
			}

			// update the setting tracker
			localMessagesTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localMessages);
			list.add(param);
			this.localMessages = (MTorMessage[]) list.toArray(new MTorMessage[list.size()]);

		}

		/**
		 * field for Name
		 */

		protected java.lang.String localName;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localNameTracker = false;

		public boolean isNameSpecified() {
			return localNameTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getName() {
			return localName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Name
		 */
		public void setName(java.lang.String param) {
			localNameTracker = param != null;

			this.localName = param;

		}

		/**
		 * field for Users
		 * This was an Array!
		 */

		protected User[] localUsers;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localUsersTracker = false;

		public boolean isUsersSpecified() {
			return localUsersTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return User[]
		 */
		public User[] getUsers() {
			return localUsers;
		}

		/**
		 * validate the array for Users
		 */
		protected void validateUsers(User[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Users
		 */
		public void setUsers(User[] param) {

			validateUsers(param);

			localUsersTracker = true;

			this.localUsers = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            User
		 */
		public void addUsers(User param) {
			if (localUsers == null) {
				localUsers = new User[] {};
			}

			// update the setting tracker
			localUsersTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localUsers);
			list.add(param);
			this.localUsers = (User[]) list.toArray(new User[list.size()]);

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":project", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "project", xmlWriter);
				}

			}
			if (localCompanyTracker) {
				if (localCompany == null) {
					throw new org.apache.axis2.databinding.ADBException("company cannot be null!!");
				}
				localCompany.serialize(new javax.xml.namespace.QName("", "company"), xmlWriter);
			}
			if (localIdTracker) {
				namespace = "";
				writeStartElement(null, namespace, "id", xmlWriter);

				if (localId == java.lang.Long.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
				}

				xmlWriter.writeEndElement();
			}
			if (localMessagesTracker) {
				if (localMessages != null) {
					for (int i = 0; i < localMessages.length; i++) {
						if (localMessages[i] != null) {
							localMessages[i].serialize(new javax.xml.namespace.QName("", "messages"), xmlWriter);
						} else {

							writeStartElement(null, "", "messages", xmlWriter);

							// write the nil attribute
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					writeStartElement(null, "", "messages", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}
			}
			if (localNameTracker) {
				namespace = "";
				writeStartElement(null, namespace, "name", xmlWriter);

				if (localName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localName);

				}

				xmlWriter.writeEndElement();
			}
			if (localUsersTracker) {
				if (localUsers != null) {
					for (int i = 0; i < localUsers.length; i++) {
						if (localUsers[i] != null) {
							localUsers[i].serialize(new javax.xml.namespace.QName("", "users"), xmlWriter);
						} else {

							writeStartElement(null, "", "users", xmlWriter);

							// write the nil attribute
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					writeStartElement(null, "", "users", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localCompanyTracker) {
				elementList.add(new javax.xml.namespace.QName("", "company"));

				if (localCompany == null) {
					throw new org.apache.axis2.databinding.ADBException("company cannot be null!!");
				}
				elementList.add(localCompany);
			}
			if (localIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "id"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
			}
			if (localMessagesTracker) {
				if (localMessages != null) {
					for (int i = 0; i < localMessages.length; i++) {

						if (localMessages[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "messages"));
							elementList.add(localMessages[i]);
						} else {

							elementList.add(new javax.xml.namespace.QName("", "messages"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("", "messages"));
					elementList.add(localMessages);

				}

			}
			if (localNameTracker) {
				elementList.add(new javax.xml.namespace.QName("", "name"));

				if (localName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
				}
			}
			if (localUsersTracker) {
				if (localUsers != null) {
					for (int i = 0; i < localUsers.length; i++) {

						if (localUsers[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "users"));
							elementList.add(localUsers[i]);
						} else {

							elementList.add(new javax.xml.namespace.QName("", "users"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("", "users"));
					elementList.add(localUsers);

				}

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Project parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Project object = new Project();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"project".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (Project) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list3 = new java.util.ArrayList();

					java.util.ArrayList list5 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "company").equals(reader.getName())) {

						object.setCompany(Company.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "id").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "id" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setId(org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setId(java.lang.Long.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "messages").equals(reader.getName())) {

						// Process the array and step past its final element's end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list3.add(null);
							reader.next();
						} else {
							list3.add(MTorMessage.Factory.parse(reader));
						}
						// loop until we find a start element that is not part of this array
						boolean loopDone3 = false;
						while (!loopDone3) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are exiting the xml structure
								loopDone3 = true;
							} else {
								if (new javax.xml.namespace.QName("", "messages").equals(reader.getName())) {

									nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list3.add(null);
										reader.next();
									} else {
										list3.add(MTorMessage.Factory.parse(reader));
									}
								} else {
									loopDone3 = true;
								}
							}
						}
						// call the converter utility to convert and set the array

						object.setMessages((MTorMessage[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(MTorMessage.class, list3));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "name").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "name" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "users").equals(reader.getName())) {

						// Process the array and step past its final element's end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list5.add(null);
							reader.next();
						} else {
							list5.add(User.Factory.parse(reader));
						}
						// loop until we find a start element that is not part of this array
						boolean loopDone5 = false;
						while (!loopDone5) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are exiting the xml structure
								loopDone5 = true;
							} else {
								if (new javax.xml.namespace.QName("", "users").equals(reader.getName())) {

									nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list5.add(null);
										reader.next();
									} else {
										list5.add(User.Factory.parse(reader));
									}
								} else {
									loopDone5 = true;
								}
							}
						}
						// call the converter utility to convert and set the array

						object.setUsers((User[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(User.class, list5));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Role extends BaseObject implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = role
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Description
		 */

		protected java.lang.String localDescription;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localDescriptionTracker = false;

		public boolean isDescriptionSpecified() {
			return localDescriptionTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDescription() {
			return localDescription;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Description
		 */
		public void setDescription(java.lang.String param) {
			localDescriptionTracker = param != null;

			this.localDescription = param;

		}

		/**
		 * field for Id
		 */

		protected long localId;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localIdTracker = false;

		public boolean isIdSpecified() {
			return localIdTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return long
		 */
		public long getId() {
			return localId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Id
		 */
		public void setId(long param) {

			// setting primitive attribute tracker to true
			localIdTracker = param != java.lang.Long.MIN_VALUE;

			this.localId = param;

		}

		/**
		 * field for Name
		 */

		protected java.lang.String localName;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localNameTracker = false;

		public boolean isNameSpecified() {
			return localNameTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getName() {
			return localName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Name
		 */
		public void setName(java.lang.String param) {
			localNameTracker = param != null;

			this.localName = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":role", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "role", xmlWriter);
			}

			if (localDescriptionTracker) {
				namespace = "";
				writeStartElement(null, namespace, "description", xmlWriter);

				if (localDescription == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("description cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDescription);

				}

				xmlWriter.writeEndElement();
			}
			if (localIdTracker) {
				namespace = "";
				writeStartElement(null, namespace, "id", xmlWriter);

				if (localId == java.lang.Long.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
				}

				xmlWriter.writeEndElement();
			}
			if (localNameTracker) {
				namespace = "";
				writeStartElement(null, namespace, "name", xmlWriter);

				if (localName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localName);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance", "type"));
			attribList.add(new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "role"));
			if (localDescriptionTracker) {
				elementList.add(new javax.xml.namespace.QName("", "description"));

				if (localDescription != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
				} else {
					throw new org.apache.axis2.databinding.ADBException("description cannot be null!!");
				}
			}
			if (localIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "id"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
			}
			if (localNameTracker) {
				elementList.add(new javax.xml.namespace.QName("", "name"));

				if (localName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Role parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Role object = new Role();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"role".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (Role) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "description").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "description" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setDescription(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "id").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "id" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setId(org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setId(java.lang.Long.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "name").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "name" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class MTorMessage implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = mTorMessage
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Content
		 */

		protected java.lang.String localContent;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localContentTracker = false;

		public boolean isContentSpecified() {
			return localContentTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getContent() {
			return localContent;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Content
		 */
		public void setContent(java.lang.String param) {
			localContentTracker = param != null;

			this.localContent = param;

		}

		/**
		 * field for Id
		 */

		protected long localId;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localIdTracker = false;

		public boolean isIdSpecified() {
			return localIdTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return long
		 */
		public long getId() {
			return localId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Id
		 */
		public void setId(long param) {

			// setting primitive attribute tracker to true
			localIdTracker = param != java.lang.Long.MIN_VALUE;

			this.localId = param;

		}

		/**
		 * field for Project
		 */

		protected Project localProject;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localProjectTracker = false;

		public boolean isProjectSpecified() {
			return localProjectTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Project
		 */
		public Project getProject() {
			return localProject;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Project
		 */
		public void setProject(Project param) {
			localProjectTracker = param != null;

			this.localProject = param;

		}

		/**
		 * field for Resolved
		 */

		protected boolean localResolved;

		/**
		 * Auto generated getter method
		 * 
		 * @return boolean
		 */
		public boolean getResolved() {
			return localResolved;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Resolved
		 */
		public void setResolved(boolean param) {

			this.localResolved = param;

		}

		/**
		 * field for Status
		 */

		protected Status localStatus;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localStatusTracker = false;

		public boolean isStatusSpecified() {
			return localStatusTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Status
		 */
		public Status getStatus() {
			return localStatus;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Status
		 */
		public void setStatus(Status param) {
			localStatusTracker = param != null;

			this.localStatus = param;

		}

		/**
		 * field for Timestamp
		 */

		protected java.util.Calendar localTimestamp;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localTimestampTracker = false;

		public boolean isTimestampSpecified() {
			return localTimestampTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.util.Calendar
		 */
		public java.util.Calendar getTimestamp() {
			return localTimestamp;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Timestamp
		 */
		public void setTimestamp(java.util.Calendar param) {
			localTimestampTracker = param != null;

			this.localTimestamp = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":mTorMessage", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "mTorMessage", xmlWriter);
				}

			}
			if (localContentTracker) {
				namespace = "";
				writeStartElement(null, namespace, "content", xmlWriter);

				if (localContent == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("content cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localContent);

				}

				xmlWriter.writeEndElement();
			}
			if (localIdTracker) {
				namespace = "";
				writeStartElement(null, namespace, "id", xmlWriter);

				if (localId == java.lang.Long.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
				}

				xmlWriter.writeEndElement();
			}
			if (localProjectTracker) {
				if (localProject == null) {
					throw new org.apache.axis2.databinding.ADBException("project cannot be null!!");
				}
				localProject.serialize(new javax.xml.namespace.QName("", "project"), xmlWriter);
			}
			namespace = "";
			writeStartElement(null, namespace, "resolved", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException("resolved cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResolved));
			}

			xmlWriter.writeEndElement();
			if (localStatusTracker) {
				if (localStatus == null) {
					throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
				}
				localStatus.serialize(new javax.xml.namespace.QName("", "status"), xmlWriter);
			}
			if (localTimestampTracker) {
				namespace = "";
				writeStartElement(null, namespace, "timestamp", xmlWriter);

				if (localTimestamp == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("timestamp cannot be null!!");

				} else {

					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTimestamp));

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localContentTracker) {
				elementList.add(new javax.xml.namespace.QName("", "content"));

				if (localContent != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContent));
				} else {
					throw new org.apache.axis2.databinding.ADBException("content cannot be null!!");
				}
			}
			if (localIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "id"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
			}
			if (localProjectTracker) {
				elementList.add(new javax.xml.namespace.QName("", "project"));

				if (localProject == null) {
					throw new org.apache.axis2.databinding.ADBException("project cannot be null!!");
				}
				elementList.add(localProject);
			}
			elementList.add(new javax.xml.namespace.QName("", "resolved"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResolved));
			if (localStatusTracker) {
				elementList.add(new javax.xml.namespace.QName("", "status"));

				if (localStatus == null) {
					throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
				}
				elementList.add(localStatus);
			}
			if (localTimestampTracker) {
				elementList.add(new javax.xml.namespace.QName("", "timestamp"));

				if (localTimestamp != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTimestamp));
				} else {
					throw new org.apache.axis2.databinding.ADBException("timestamp cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static MTorMessage parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				MTorMessage object = new MTorMessage();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"mTorMessage".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (MTorMessage) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "content").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "content" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setContent(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "id").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "id" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setId(org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setId(java.lang.Long.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "project").equals(reader.getName())) {

						object.setProject(Project.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "resolved").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "resolved" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setResolved(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "status").equals(reader.getName())) {

						object.setStatus(Status.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "timestamp").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "timestamp" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setTimestamp(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class ExtensionMapper {

		public static java.lang.Object getTypeObject(java.lang.String namespaceURI, java.lang.String typeName, javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "company".equals(typeName)) {

				return Company.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "address".equals(typeName)) {

				return Address.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "saveSoapMessageResponse".equals(typeName)) {

				return SaveSoapMessageResponse.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "baseObject".equals(typeName)) {

				return BaseObject.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "project".equals(typeName)) {

				return Project.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "user".equals(typeName)) {

				return User.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "role".equals(typeName)) {

				return Role.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "status".equals(typeName)) {

				return Status.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "mTorMessage".equals(typeName)) {

				return MTorMessage.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "getMessagesWithTimestampResponse".equals(typeName)) {

				return GetMessagesWithTimestampResponse.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "saveSoapMessage".equals(typeName)) {

				return SaveSoapMessage.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "soapMessage".equals(typeName)) {

				return SoapMessage.Factory.parse(reader);

			}

			if ("http://service.mtor.bhit.nl/".equals(namespaceURI) && "getMessagesWithTimestamp".equals(typeName)) {

				return GetMessagesWithTimestamp.Factory.parse(reader);

			}

			throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
		}

	}

	public static class User extends BaseObject implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = user
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for AccountExpired
		 */

		protected boolean localAccountExpired;

		/**
		 * Auto generated getter method
		 * 
		 * @return boolean
		 */
		public boolean getAccountExpired() {
			return localAccountExpired;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AccountExpired
		 */
		public void setAccountExpired(boolean param) {

			this.localAccountExpired = param;

		}

		/**
		 * field for AccountLocked
		 */

		protected boolean localAccountLocked;

		/**
		 * Auto generated getter method
		 * 
		 * @return boolean
		 */
		public boolean getAccountLocked() {
			return localAccountLocked;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AccountLocked
		 */
		public void setAccountLocked(boolean param) {

			this.localAccountLocked = param;

		}

		/**
		 * field for Address
		 */

		protected Address localAddress;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localAddressTracker = false;

		public boolean isAddressSpecified() {
			return localAddressTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Address
		 */
		public Address getAddress() {
			return localAddress;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Address
		 */
		public void setAddress(Address param) {
			localAddressTracker = param != null;

			this.localAddress = param;

		}

		/**
		 * field for CredentialsExpired
		 */

		protected boolean localCredentialsExpired;

		/**
		 * Auto generated getter method
		 * 
		 * @return boolean
		 */
		public boolean getCredentialsExpired() {
			return localCredentialsExpired;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CredentialsExpired
		 */
		public void setCredentialsExpired(boolean param) {

			this.localCredentialsExpired = param;

		}

		/**
		 * field for Email
		 */

		protected java.lang.String localEmail;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localEmailTracker = false;

		public boolean isEmailSpecified() {
			return localEmailTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getEmail() {
			return localEmail;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Email
		 */
		public void setEmail(java.lang.String param) {
			localEmailTracker = param != null;

			this.localEmail = param;

		}

		/**
		 * field for Enabled
		 */

		protected boolean localEnabled;

		/**
		 * Auto generated getter method
		 * 
		 * @return boolean
		 */
		public boolean getEnabled() {
			return localEnabled;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Enabled
		 */
		public void setEnabled(boolean param) {

			this.localEnabled = param;

		}

		/**
		 * field for FirstName
		 */

		protected java.lang.String localFirstName;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localFirstNameTracker = false;

		public boolean isFirstNameSpecified() {
			return localFirstNameTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getFirstName() {
			return localFirstName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FirstName
		 */
		public void setFirstName(java.lang.String param) {
			localFirstNameTracker = param != null;

			this.localFirstName = param;

		}

		/**
		 * field for Id
		 */

		protected long localId;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localIdTracker = false;

		public boolean isIdSpecified() {
			return localIdTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return long
		 */
		public long getId() {
			return localId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Id
		 */
		public void setId(long param) {

			// setting primitive attribute tracker to true
			localIdTracker = param != java.lang.Long.MIN_VALUE;

			this.localId = param;

		}

		/**
		 * field for LastName
		 */

		protected java.lang.String localLastName;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localLastNameTracker = false;

		public boolean isLastNameSpecified() {
			return localLastNameTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getLastName() {
			return localLastName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            LastName
		 */
		public void setLastName(java.lang.String param) {
			localLastNameTracker = param != null;

			this.localLastName = param;

		}

		/**
		 * field for PhoneNumber
		 */

		protected java.lang.String localPhoneNumber;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localPhoneNumberTracker = false;

		public boolean isPhoneNumberSpecified() {
			return localPhoneNumberTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getPhoneNumber() {
			return localPhoneNumber;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PhoneNumber
		 */
		public void setPhoneNumber(java.lang.String param) {
			localPhoneNumberTracker = param != null;

			this.localPhoneNumber = param;

		}

		/**
		 * field for Projects
		 * This was an Array!
		 */

		protected Project[] localProjects;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localProjectsTracker = false;

		public boolean isProjectsSpecified() {
			return localProjectsTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Project[]
		 */
		public Project[] getProjects() {
			return localProjects;
		}

		/**
		 * validate the array for Projects
		 */
		protected void validateProjects(Project[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Projects
		 */
		public void setProjects(Project[] param) {

			validateProjects(param);

			localProjectsTracker = true;

			this.localProjects = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            Project
		 */
		public void addProjects(Project param) {
			if (localProjects == null) {
				localProjects = new Project[] {};
			}

			// update the setting tracker
			localProjectsTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localProjects);
			list.add(param);
			this.localProjects = (Project[]) list.toArray(new Project[list.size()]);

		}

		/**
		 * field for Roles
		 * This was an Array!
		 */

		protected Role[] localRoles;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localRolesTracker = false;

		public boolean isRolesSpecified() {
			return localRolesTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Role[]
		 */
		public Role[] getRoles() {
			return localRoles;
		}

		/**
		 * validate the array for Roles
		 */
		protected void validateRoles(Role[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Roles
		 */
		public void setRoles(Role[] param) {

			validateRoles(param);

			localRolesTracker = true;

			this.localRoles = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            Role
		 */
		public void addRoles(Role param) {
			if (localRoles == null) {
				localRoles = new Role[] {};
			}

			// update the setting tracker
			localRolesTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localRoles);
			list.add(param);
			this.localRoles = (Role[]) list.toArray(new Role[list.size()]);

		}

		/**
		 * field for Username
		 */

		protected java.lang.String localUsername;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localUsernameTracker = false;

		public boolean isUsernameSpecified() {
			return localUsernameTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getUsername() {
			return localUsername;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Username
		 */
		public void setUsername(java.lang.String param) {
			localUsernameTracker = param != null;

			this.localUsername = param;

		}

		/**
		 * field for Version
		 */

		protected int localVersion;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localVersionTracker = false;

		public boolean isVersionSpecified() {
			return localVersionTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getVersion() {
			return localVersion;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Version
		 */
		public void setVersion(int param) {

			// setting primitive attribute tracker to true
			localVersionTracker = param != java.lang.Integer.MIN_VALUE;

			this.localVersion = param;

		}

		/**
		 * field for Website
		 */

		protected java.lang.String localWebsite;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localWebsiteTracker = false;

		public boolean isWebsiteSpecified() {
			return localWebsiteTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getWebsite() {
			return localWebsite;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Website
		 */
		public void setWebsite(java.lang.String param) {
			localWebsiteTracker = param != null;

			this.localWebsite = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":user", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "user", xmlWriter);
			}

			namespace = "";
			writeStartElement(null, namespace, "accountExpired", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException("accountExpired cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAccountExpired));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			writeStartElement(null, namespace, "accountLocked", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException("accountLocked cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAccountLocked));
			}

			xmlWriter.writeEndElement();
			if (localAddressTracker) {
				if (localAddress == null) {
					throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
				}
				localAddress.serialize(new javax.xml.namespace.QName("", "address"), xmlWriter);
			}
			namespace = "";
			writeStartElement(null, namespace, "credentialsExpired", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException("credentialsExpired cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCredentialsExpired));
			}

			xmlWriter.writeEndElement();
			if (localEmailTracker) {
				namespace = "";
				writeStartElement(null, namespace, "email", xmlWriter);

				if (localEmail == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localEmail);

				}

				xmlWriter.writeEndElement();
			}
			namespace = "";
			writeStartElement(null, namespace, "enabled", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException("enabled cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnabled));
			}

			xmlWriter.writeEndElement();
			if (localFirstNameTracker) {
				namespace = "";
				writeStartElement(null, namespace, "firstName", xmlWriter);

				if (localFirstName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localFirstName);

				}

				xmlWriter.writeEndElement();
			}
			if (localIdTracker) {
				namespace = "";
				writeStartElement(null, namespace, "id", xmlWriter);

				if (localId == java.lang.Long.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
				}

				xmlWriter.writeEndElement();
			}
			if (localLastNameTracker) {
				namespace = "";
				writeStartElement(null, namespace, "lastName", xmlWriter);

				if (localLastName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localLastName);

				}

				xmlWriter.writeEndElement();
			}
			if (localPhoneNumberTracker) {
				namespace = "";
				writeStartElement(null, namespace, "phoneNumber", xmlWriter);

				if (localPhoneNumber == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("phoneNumber cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localPhoneNumber);

				}

				xmlWriter.writeEndElement();
			}
			if (localProjectsTracker) {
				if (localProjects != null) {
					for (int i = 0; i < localProjects.length; i++) {
						if (localProjects[i] != null) {
							localProjects[i].serialize(new javax.xml.namespace.QName("", "projects"), xmlWriter);
						} else {

							writeStartElement(null, "", "projects", xmlWriter);

							// write the nil attribute
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					writeStartElement(null, "", "projects", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}
			}
			if (localRolesTracker) {
				if (localRoles != null) {
					for (int i = 0; i < localRoles.length; i++) {
						if (localRoles[i] != null) {
							localRoles[i].serialize(new javax.xml.namespace.QName("", "roles"), xmlWriter);
						} else {

							writeStartElement(null, "", "roles", xmlWriter);

							// write the nil attribute
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					writeStartElement(null, "", "roles", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}
			}
			if (localUsernameTracker) {
				namespace = "";
				writeStartElement(null, namespace, "username", xmlWriter);

				if (localUsername == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("username cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localUsername);

				}

				xmlWriter.writeEndElement();
			}
			if (localVersionTracker) {
				namespace = "";
				writeStartElement(null, namespace, "version", xmlWriter);

				if (localVersion == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException("version cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVersion));
				}

				xmlWriter.writeEndElement();
			}
			if (localWebsiteTracker) {
				namespace = "";
				writeStartElement(null, namespace, "website", xmlWriter);

				if (localWebsite == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("website cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localWebsite);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance", "type"));
			attribList.add(new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "user"));

			elementList.add(new javax.xml.namespace.QName("", "accountExpired"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAccountExpired));

			elementList.add(new javax.xml.namespace.QName("", "accountLocked"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAccountLocked));
			if (localAddressTracker) {
				elementList.add(new javax.xml.namespace.QName("", "address"));

				if (localAddress == null) {
					throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
				}
				elementList.add(localAddress);
			}
			elementList.add(new javax.xml.namespace.QName("", "credentialsExpired"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCredentialsExpired));
			if (localEmailTracker) {
				elementList.add(new javax.xml.namespace.QName("", "email"));

				if (localEmail != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
				} else {
					throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");
				}
			}
			elementList.add(new javax.xml.namespace.QName("", "enabled"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnabled));
			if (localFirstNameTracker) {
				elementList.add(new javax.xml.namespace.QName("", "firstName"));

				if (localFirstName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirstName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");
				}
			}
			if (localIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "id"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
			}
			if (localLastNameTracker) {
				elementList.add(new javax.xml.namespace.QName("", "lastName"));

				if (localLastName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");
				}
			}
			if (localPhoneNumberTracker) {
				elementList.add(new javax.xml.namespace.QName("", "phoneNumber"));

				if (localPhoneNumber != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhoneNumber));
				} else {
					throw new org.apache.axis2.databinding.ADBException("phoneNumber cannot be null!!");
				}
			}
			if (localProjectsTracker) {
				if (localProjects != null) {
					for (int i = 0; i < localProjects.length; i++) {

						if (localProjects[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "projects"));
							elementList.add(localProjects[i]);
						} else {

							elementList.add(new javax.xml.namespace.QName("", "projects"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("", "projects"));
					elementList.add(localProjects);

				}

			}
			if (localRolesTracker) {
				if (localRoles != null) {
					for (int i = 0; i < localRoles.length; i++) {

						if (localRoles[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "roles"));
							elementList.add(localRoles[i]);
						} else {

							elementList.add(new javax.xml.namespace.QName("", "roles"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("", "roles"));
					elementList.add(localRoles);

				}

			}
			if (localUsernameTracker) {
				elementList.add(new javax.xml.namespace.QName("", "username"));

				if (localUsername != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUsername));
				} else {
					throw new org.apache.axis2.databinding.ADBException("username cannot be null!!");
				}
			}
			if (localVersionTracker) {
				elementList.add(new javax.xml.namespace.QName("", "version"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVersion));
			}
			if (localWebsiteTracker) {
				elementList.add(new javax.xml.namespace.QName("", "website"));

				if (localWebsite != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWebsite));
				} else {
					throw new org.apache.axis2.databinding.ADBException("website cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static User parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				User object = new User();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"user".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (User) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list11 = new java.util.ArrayList();

					java.util.ArrayList list12 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "accountExpired").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "accountExpired" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setAccountExpired(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "accountLocked").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "accountLocked" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setAccountLocked(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "address").equals(reader.getName())) {

						object.setAddress(Address.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "credentialsExpired").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "credentialsExpired" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setCredentialsExpired(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "email").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "email" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setEmail(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "enabled").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "enabled" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setEnabled(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "firstName").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "firstName" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setFirstName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "id").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "id" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setId(org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setId(java.lang.Long.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "lastName").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "lastName" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setLastName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "phoneNumber").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "phoneNumber" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setPhoneNumber(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "projects").equals(reader.getName())) {

						// Process the array and step past its final element's end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list11.add(null);
							reader.next();
						} else {
							list11.add(Project.Factory.parse(reader));
						}
						// loop until we find a start element that is not part of this array
						boolean loopDone11 = false;
						while (!loopDone11) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are exiting the xml structure
								loopDone11 = true;
							} else {
								if (new javax.xml.namespace.QName("", "projects").equals(reader.getName())) {

									nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list11.add(null);
										reader.next();
									} else {
										list11.add(Project.Factory.parse(reader));
									}
								} else {
									loopDone11 = true;
								}
							}
						}
						// call the converter utility to convert and set the array

						object.setProjects((Project[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(Project.class, list11));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "roles").equals(reader.getName())) {

						// Process the array and step past its final element's end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list12.add(null);
							reader.next();
						} else {
							list12.add(Role.Factory.parse(reader));
						}
						// loop until we find a start element that is not part of this array
						boolean loopDone12 = false;
						while (!loopDone12) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are exiting the xml structure
								loopDone12 = true;
							} else {
								if (new javax.xml.namespace.QName("", "roles").equals(reader.getName())) {

									nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list12.add(null);
										reader.next();
									} else {
										list12.add(Role.Factory.parse(reader));
									}
								} else {
									loopDone12 = true;
								}
							}
						}
						// call the converter utility to convert and set the array

						object.setRoles((Role[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(Role.class, list12));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "username").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "username" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setUsername(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "version").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "version" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setVersion(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setVersion(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "website").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "website" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setWebsite(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class SaveSoapMessageResponseE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "saveSoapMessageResponse", "ns1");

		/**
		 * field for SaveSoapMessageResponse
		 */

		protected SaveSoapMessageResponse localSaveSoapMessageResponse;

		/**
		 * Auto generated getter method
		 * 
		 * @return SaveSoapMessageResponse
		 */
		public SaveSoapMessageResponse getSaveSoapMessageResponse() {
			return localSaveSoapMessageResponse;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SaveSoapMessageResponse
		 */
		public void setSaveSoapMessageResponse(SaveSoapMessageResponse param) {

			this.localSaveSoapMessageResponse = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it

			if (localSaveSoapMessageResponse == null) {
				throw new org.apache.axis2.databinding.ADBException("saveSoapMessageResponse cannot be null!");
			}
			localSaveSoapMessageResponse.serialize(MY_QNAME, xmlWriter);

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it
			return localSaveSoapMessageResponse.getPullParser(MY_QNAME);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static SaveSoapMessageResponseE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SaveSoapMessageResponseE object = new SaveSoapMessageResponseE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "saveSoapMessageResponse").equals(reader.getName())) {

								object.setSaveSoapMessageResponse(SaveSoapMessageResponse.Factory.parse(reader));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class SaveSoapMessageE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "saveSoapMessage", "ns1");

		/**
		 * field for SaveSoapMessage
		 */

		protected SaveSoapMessage localSaveSoapMessage;

		/**
		 * Auto generated getter method
		 * 
		 * @return SaveSoapMessage
		 */
		public SaveSoapMessage getSaveSoapMessage() {
			return localSaveSoapMessage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SaveSoapMessage
		 */
		public void setSaveSoapMessage(SaveSoapMessage param) {

			this.localSaveSoapMessage = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it

			if (localSaveSoapMessage == null) {
				throw new org.apache.axis2.databinding.ADBException("saveSoapMessage cannot be null!");
			}
			localSaveSoapMessage.serialize(MY_QNAME, xmlWriter);

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it
			return localSaveSoapMessage.getPullParser(MY_QNAME);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static SaveSoapMessageE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SaveSoapMessageE object = new SaveSoapMessageE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "saveSoapMessage").equals(reader.getName())) {

								object.setSaveSoapMessage(SaveSoapMessage.Factory.parse(reader));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetMessagesWithTimestampResponse implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = getMessagesWithTimestampResponse
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for _return
		 * This was an Array!
		 */

		protected MTorMessage[] local_return;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean local_returnTracker = false;

		public boolean is_returnSpecified() {
			return local_returnTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return MTorMessage[]
		 */
		public MTorMessage[] get_return() {
			return local_return;
		}

		/**
		 * validate the array for _return
		 */
		protected void validate_return(MTorMessage[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _return
		 */
		public void set_return(MTorMessage[] param) {

			validate_return(param);

			local_returnTracker = param != null;

			this.local_return = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            MTorMessage
		 */
		public void add_return(MTorMessage param) {
			if (local_return == null) {
				local_return = new MTorMessage[] {};
			}

			// update the setting tracker
			local_returnTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(local_return);
			list.add(param);
			this.local_return = (MTorMessage[]) list.toArray(new MTorMessage[list.size()]);

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":getMessagesWithTimestampResponse", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "getMessagesWithTimestampResponse", xmlWriter);
				}

			}
			if (local_returnTracker) {
				if (local_return != null) {
					for (int i = 0; i < local_return.length; i++) {
						if (local_return[i] != null) {
							local_return[i].serialize(new javax.xml.namespace.QName("", "return"), xmlWriter);
						} else {

							// we don't have to do any thing since minOccures is zero

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException("return cannot be null!!");

				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (local_returnTracker) {
				if (local_return != null) {
					for (int i = 0; i < local_return.length; i++) {

						if (local_return[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "return"));
							elementList.add(local_return[i]);
						} else {

							// nothing to do

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException("return cannot be null!!");

				}

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static GetMessagesWithTimestampResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetMessagesWithTimestampResponse object = new GetMessagesWithTimestampResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"getMessagesWithTimestampResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (GetMessagesWithTimestampResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "return").equals(reader.getName())) {

						// Process the array and step past its final element's end.
						list1.add(MTorMessage.Factory.parse(reader));

						// loop until we find a start element that is not part of this array
						boolean loopDone1 = false;
						while (!loopDone1) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are exiting the xml structure
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("", "return").equals(reader.getName())) {
									list1.add(MTorMessage.Factory.parse(reader));

								} else {
									loopDone1 = true;
								}
							}
						}
						// call the converter utility to convert and set the array

						object.set_return((MTorMessage[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(MTorMessage.class, list1));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class SoapMessage implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = soapMessage
		 * Namespace URI = http://service.mtor.bhit.nl/
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Content
		 */

		protected java.lang.String localContent;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localContentTracker = false;

		public boolean isContentSpecified() {
			return localContentTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getContent() {
			return localContent;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Content
		 */
		public void setContent(java.lang.String param) {
			localContentTracker = param != null;

			this.localContent = param;

		}

		/**
		 * field for ProjectId
		 */

		protected long localProjectId;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localProjectIdTracker = false;

		public boolean isProjectIdSpecified() {
			return localProjectIdTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return long
		 */
		public long getProjectId() {
			return localProjectId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ProjectId
		 */
		public void setProjectId(long param) {

			// setting primitive attribute tracker to true
			localProjectIdTracker = param != java.lang.Long.MIN_VALUE;

			this.localProjectId = param;

		}

		/**
		 * field for Status
		 */

		protected Status localStatus;

		/*
		 * This tracker boolean wil be used to detect whether the user called the set method
		 * for this attribute. It will be used to determine whether to include this field
		 * in the serialized XML
		 */
		protected boolean localStatusTracker = false;

		public boolean isStatusSpecified() {
			return localStatusTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Status
		 */
		public Status getStatus() {
			return localStatus;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Status
		 */
		public void setStatus(Status param) {
			localStatusTracker = param != null;

			this.localStatus = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://service.mtor.bhit.nl/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":soapMessage", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "soapMessage", xmlWriter);
				}

			}
			if (localContentTracker) {
				namespace = "";
				writeStartElement(null, namespace, "content", xmlWriter);

				if (localContent == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException("content cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localContent);

				}

				xmlWriter.writeEndElement();
			}
			if (localProjectIdTracker) {
				namespace = "";
				writeStartElement(null, namespace, "projectId", xmlWriter);

				if (localProjectId == java.lang.Long.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException("projectId cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProjectId));
				}

				xmlWriter.writeEndElement();
			}
			if (localStatusTracker) {
				if (localStatus == null) {
					throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
				}
				localStatus.serialize(new javax.xml.namespace.QName("", "status"), xmlWriter);
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localContentTracker) {
				elementList.add(new javax.xml.namespace.QName("", "content"));

				if (localContent != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContent));
				} else {
					throw new org.apache.axis2.databinding.ADBException("content cannot be null!!");
				}
			}
			if (localProjectIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "projectId"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProjectId));
			}
			if (localStatusTracker) {
				elementList.add(new javax.xml.namespace.QName("", "status"));

				if (localStatus == null) {
					throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
				}
				elementList.add(localStatus);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static SoapMessage parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SoapMessage object = new SoapMessage();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"soapMessage".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (SoapMessage) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "content").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "content" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setContent(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "projectId").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "projectId" + "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setProjectId(org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setProjectId(java.lang.Long.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "status").equals(reader.getName())) {

						object.setStatus(Status.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetMessagesWithTimestampE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "getMessagesWithTimestamp",
				"ns1");

		/**
		 * field for GetMessagesWithTimestamp
		 */

		protected GetMessagesWithTimestamp localGetMessagesWithTimestamp;

		/**
		 * Auto generated getter method
		 * 
		 * @return GetMessagesWithTimestamp
		 */
		public GetMessagesWithTimestamp getGetMessagesWithTimestamp() {
			return localGetMessagesWithTimestamp;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            GetMessagesWithTimestamp
		 */
		public void setGetMessagesWithTimestamp(GetMessagesWithTimestamp param) {

			this.localGetMessagesWithTimestamp = param;

		}

		/**
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		@Override
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		@Override
		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it

			if (localGetMessagesWithTimestamp == null) {
				throw new org.apache.axis2.databinding.ADBException("getMessagesWithTimestamp cannot be null!");
			}
			localGetMessagesWithTimestamp.serialize(MY_QNAME, xmlWriter);

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://service.mtor.bhit.nl/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 */
		@Override
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with it
			return localGetMessagesWithTimestamp.getPullParser(MY_QNAME);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 * If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static GetMessagesWithTimestampE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetMessagesWithTimestampE object = new GetMessagesWithTimestampE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName("http://service.mtor.bhit.nl/", "getMessagesWithTimestamp").equals(reader.getName())) {

								object.setGetMessagesWithTimestamp(GetMessagesWithTimestamp.Factory.parse(reader));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	private org.apache.axiom.om.OMElement toOM(nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
			nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE.MY_QNAME, factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
			nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE.MY_QNAME, factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type, java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

		try {

			if (nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE.class.equals(type)) {

				return nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE.class.equals(type)) {

				return nl.bhit.mtor.client.wsdl.MessageServiceStub.GetMessagesWithTimestampResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE.class.equals(type)) {

				return nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE.class.equals(type)) {

				return nl.bhit.mtor.client.wsdl.MessageServiceStub.SaveSoapMessageResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
