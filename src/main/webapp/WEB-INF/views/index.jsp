<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/header.jspf" %> 
<%@ include file="/WEB-INF/jspf/debug.jspf" %> 

<div class="row">
                
    <div class="col-12 col-md-6">
        
        <form method="post" accept-charset="ISO-8859-1">
            
            <input type="hidden" name="action" value="login">
            
            <label for="name" class="cols-sm-2 control-label">Name:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="fas fa-user" aria-hidden="true"></i></div>
                </div>
                <input type="text" class="form-control" name="name" id="name"  placeholder="Name" value="${name}"/>
            </div>

            <label for="name" class="cols-sm-2 control-label">Password:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="fas fa-key" aria-hidden="true"></i></div>
                </div>
                <input type="password" class="form-control" name="pw" id="pw"  placeholder="Password"/>
            </div>

            <button class="btn btn-primary" type="submit">Sign in</button>

        </form>
            
        <br><p> user: a / pw: 123 </p>

    </div>

    <div class="wall"></div>
    
    <div class="col-12 col-md-6">
        
        <form method="post" accept-charset="ISO-8859-1">

            <input type="hidden" name="action" value="register">
            
            <label for="name" class="cols-sm-2 control-label">Name:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="fas fa-user" aria-hidden="true"></i></div>
                </div>
                <input type="text" class="form-control" name="name" id="name"  placeholder="Name" value="${name}"/>
            </div>

            <label for="pw" class="cols-sm-2 control-label">Password:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="fas fa-key" aria-hidden="true"></i></div>
                </div>
                <input type="password" class="form-control" name="pw" id="pw"  placeholder="Password" value="${pw}"/>
            </div>
            
            <label for="pw2" class="cols-sm-2 control-label">Confirm Password:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="fas fa-key" aria-hidden="true"></i></div>
                </div>
                <input type="password" class="form-control" name="pw2" id="pw2"  placeholder="Password" value="${pw2}"/>
            </div>

            <button class="btn btn-primary" type="submit">Sign in</button>

        </form>


    </div>
</div>
${err}

<%@ include file="/WEB-INF/jspf/footer.jspf" %>