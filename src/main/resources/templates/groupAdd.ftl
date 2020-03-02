<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Group name:<@spring.formInput "groupForm.name" "" "text"/>
    <br>
    Group description:<@spring.formInput "groupForm.description", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>