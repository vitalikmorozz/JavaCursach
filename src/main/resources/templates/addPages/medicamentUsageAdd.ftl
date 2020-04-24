<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Medicament Usage editor</h1>
    <form name="medicamentUsage" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Medicament Usage name:</label>
            <@spring.formInput "medicamentUsage.name", "name='nameInput' id='nameInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="descriptionInput">Medicament Usage description:</label>
            <@spring.formInput "medicamentUsage.description", "name='descriptionInput' id='descriptionInput' required", "text"/>
        </div>


        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>