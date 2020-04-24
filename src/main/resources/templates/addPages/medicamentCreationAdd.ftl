<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Medicament Creations technique editor</h1>
    <form name="medicamentCreation" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Technique name:</label>
            <@spring.formInput "medicamentCreation.name", "name='nameInput' id='nameInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="descriptionInput">Technique description:</label>
            <@spring.formInput "medicamentCreation.creationDescription", "name='descriptionInput' id='descriptionInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="ingredientAmountInput">Technique ingredient amount:</label>
            <@spring.formInput "medicamentCreation.ingredientAmount", "name='ingredientAmountInput' id='ingredientAmountInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="ingredientIdInput">Technique ingredient:</label>
            <@spring.formSingleSelect "medicamentCreation.ingredientId", ingredients, "text"/>
        </div>


        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>