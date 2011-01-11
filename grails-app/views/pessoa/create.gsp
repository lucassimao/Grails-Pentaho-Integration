

<%@ page import="pentaho.exemplo.Pessoa" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'pessoa.label', default: 'Pessoa')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${pessoaInstance}">
            <div class="errors">
                <g:renderErrors bean="${pessoaInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email"><g:message code="pessoa.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pessoaInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${pessoaInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nome"><g:message code="pessoa.nome.label" default="Nome" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pessoaInstance, field: 'nome', 'errors')}">
                                    <g:textField name="nome" value="${pessoaInstance?.nome}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tipoPessoa"><g:message code="pessoa.tipoPessoa.label" default="Tipo Pessoa" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pessoaInstance, field: 'tipoPessoa', 'errors')}">
                                    <g:select name="tipoPessoa" from="${pentaho.exemplo.TipoPessoa?.values()}" keys="${pentaho.exemplo.TipoPessoa?.values()*.name()}" value="${pessoaInstance?.tipoPessoa?.name()}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
