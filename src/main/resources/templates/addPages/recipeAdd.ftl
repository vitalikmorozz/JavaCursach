<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Recipe editor</h1>
    <form name="recipe" action="" method="POST">

        <div class="form-group">
            <label for="typeInput">Recipe doctor:</label>
            <@spring.formSingleSelect "recipe.doctorId", doctors, "text"/>
        </div>

        <div class="form-group">
            <label for="usageInput">Recipe client:</label>
            <@spring.formSingleSelect "recipe.clientId", clients, "text"/>
        </div>

        <div class="form-group">
            <label for="diagnosisInput">Recipe diagnosis:</label>
            <@spring.formInput "recipe.diagnosis", "name='minimalAmountInput' id='minimalAmountInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="creationInput">Recipe medicament:</label>
            <@spring.formSingleSelect "recipe.medicamentId", medicaments, "text"/>
        </div>

        <div class="form-group">
            <label for="amountInput">Recipe medicament amount:</label>
            <@spring.formInput "recipe.medicamentAmount", "name='amountInput' id='amountInput' required", "text"/>
        </div>

        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>