<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/header.jspf" %> 
<%@ include file="/WEB-INF/jspf/debug.jspf" %> 

<div class="row">

    
    <div class="col-12 col-md-6">

        <form method="post" action="${baseUrl}build/" accept-charset="ISO-8859-1">

            <input type="hidden" name="action" value="buildHouse">

            <label for="height">Height:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="far fa-building" aria-hidden="true"></i></div>
                </div>
                <input type="number" min="7" max="1000" required class="form-control" name="height" id="height"  placeholder="Height" value="${height}"/>
            </div>

            <label for="pw" class="cols-sm-2 control-label">Width:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="fas fa-home" aria-hidden="true"></i></div>
                </div>
                <input type="number" min="8" max="1000" required class="form-control" name="width" id="width"  placeholder="Width" value="${width}"/>
            </div>

            <label for="pw2" class="cols-sm-2 control-label">Depth:</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text"><i class="fas fa-warehouse" aria-hidden="true"></i></div>
                </div>
                <input type="number" min="6" max="1000" required class="form-control" name="depth" id="depth"  placeholder="Depth" value="${depth}"/>
            </div>

            <button class="btn btn-primary" type="submit">Build</button>

        </form>
    </div>
            
    <div class="wall wall-6"></div>
    
    <div class="col-12 col-md-6">
        ${houseDetails}
        ${houseConfirm}
    </div>
            
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>