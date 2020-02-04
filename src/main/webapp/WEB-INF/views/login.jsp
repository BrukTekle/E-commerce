<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<script>
    $(document).ready(function () {
        $( "form" ).submit(function( event ) {
            event.preventDefault();
            alert($(this).serialize());
            $.ajax({
                url: "login",
                type: 'Post',
                async: false,
                data: {
                    "data": event.target.id
                },
                success: function (data) {
                    $('#main').load(data);
                    console.log(data);
                },
                error: function (data) {
                    $('#main').replaceWith(data.responseText);
                    // $('#main').reload()
                    console.log(data.responseText);
                }

            });
        });
    });


</script>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Please sign in</h3>
    </div>
    <div class="panel-body">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br/>
            </div>
        </c:if>
        <form action="<spring:url value="/login"></spring:url>" method="post" id="form">
            <fieldset>
                <div class="form-group">
                    <input class="form:input-large" placeholder="User Name" name='username' type="text">
                </div>
                <div class="form-group">
                    <input class=" form:input-large" placeholder="Password" name='password' type="password" value="">
                </div>
                <div class="form-group">
                    <input type='checkbox' name="keepMe"/>Remember Me? <br/>
                </div>
                <input class="btn btn-lg btn-success btn-mini" type="submit" value="Login">
            </fieldset>
            <security:csrfInput/>
        </form>
    </div>
</div>


