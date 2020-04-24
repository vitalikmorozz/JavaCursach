<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Medicament Type editor</h1>
    <form name="medicamentType" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Medicament Type name:</label>
            <@spring.formInput "medicamentType.name", "name='nameInput' id='nameInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="descriptionInput">Medicament Type description:</label>
            <@spring.formInput "medicamentType.description", "name='descriptionInput' id='descriptionInput' required", "text"/>
        </div>


        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>