<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="messageDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='messageDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="messageList.message"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="messageDetail.heading"/></h2>
    <fmt:message key="messageDetail.message"/>
</div>

<div class="span7">
    <s:form id="messageForm" action="saveMessage" method="post" validate="true" cssClass="well form-horizontal">
            <s:hidden key="message.id"/>
        <s:textfield key="message.content" required="true" maxlength="255" />    
        <!-- todo: change this to read the identifier field from the other pojo -->
        <s:select list="statasList" key="message.statas"></s:select>
        <s:select key="message.projectCompany.id" list="projectCompanyList" listKey="id" listValue="name"></s:select>

        <div id="actions" class="form-actions">
            <s:submit type="button" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty message.id}">
                <s:submit type="button" cssClass="btn btn-warning" method="delete" key="button.delete"
                    onclick="return confirmMessage(msgDelConfirm)" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/> 
                </s:submit>
            </c:if>
            <s:submit type="button" cssClass="btn" method="cancel" key="button.cancel" theme="simple">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </s:submit>
        </div>
    </s:form>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['messageForm']).focus();
    });
</script>
