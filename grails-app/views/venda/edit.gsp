

<%@ page import="pentaho.exemplo.Venda" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'venda.label', default: 'Venda')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${vendaInstance}">
            <div class="errors">
                <g:renderErrors bean="${vendaInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${vendaInstance?.id}" />
                <g:hiddenField name="version" value="${vendaInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="cliente"><g:message code="venda.cliente.label" default="Cliente" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: vendaInstance, field: 'cliente', 'errors')}">
                                    <g:select name="cliente.id" from="${pentaho.exemplo.Pessoa.list()}" optionKey="id" value="${vendaInstance?.cliente?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="itensDeVenda"><g:message code="venda.itensDeVenda.label" default="Itens De Venda" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: vendaInstance, field: 'itensDeVenda', 'errors')}">
                                    <g:select name="itensDeVenda" from="${pentaho.exemplo.ItemVenda.list()}" multiple="yes" optionKey="id" size="5" value="${vendaInstance?.itensDeVenda*.id}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
