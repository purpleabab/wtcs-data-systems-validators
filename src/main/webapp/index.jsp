<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>WTCS Data File Validator</title>
    <script src="script/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function() {

            $("#fileValidate").submit(function() {
                var fileValidateForm = $("#fileValidate");
                var fileValidateAction = fileValidateForm.attr("action");
                var selectedDataSystem = $("#dataSystem option:selected");

                fileValidateForm.attr("action", fileValidateAction + "/" + selectedDataSystem.val());
                return true;
            });

        });
    </script>
</head>

<body>
<h1>WTCS Data File Validator</h1>

<form id="fileValidate" action="<%=request.getContextPath()%>/wtcs/file/validate" method="post" enctype="multipart/form-data">
    <select id="dataSystem" name="dataSystem">
        <option value="client" selected="selected">Client</option>
    </select>
    <input type="file" name="wtcsFile" />
    <input type="submit" value="Upload File" />
</form>

</body>
</html>
