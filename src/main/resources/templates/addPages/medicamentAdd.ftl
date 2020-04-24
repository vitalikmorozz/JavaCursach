<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Medicament editor</h1>
    <form name="medicament" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Medicament name:</label>
            <@spring.formInput "medicament.name", "name='nameInput' id='nameInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="descriptionInput">Medicament description:</label>
            <@spring.formInput "medicament.description", "name='descriptionInput' id='descriptionInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="priceInput">Medicament price:</label>
            <@spring.formInput "medicament.price", "name='priceInput' id='priceInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="currentAmountInput">Medicament current amount:</label>
            <@spring.formInput "medicament.currentAmount", "name='currentAmountInput' id='currentAmountInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="minimalAmountInput">Medicament minimal amount:</label>
            <@spring.formInput "medicament.minimalAmount", "name='minimalAmountInput' id='minimalAmountInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="expirationDateInput">Medicament expiration date:</label>
            <@spring.formInput "medicament.expirationDate", "name='expirationDateInput' id='expirationDateInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="typeInput">Medicament type:</label>
            <@spring.formSingleSelect "medicament.medicamentTypeId", types, "text"/>
        </div>

        <div class="form-group">
            <label for="usageInput">Medicament usage:</label>
            <@spring.formSingleSelect "medicament.medicamentUsageId", usages, "text"/>
        </div>

        <div class="form-group">
            <label for="creationInput">Medicament creation:</label>
            <@spring.formSingleSelect "medicament.medicamentCreationId", creations, "text"/>
        </div>




        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>