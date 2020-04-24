<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Ingredients editor</h1>
    <form name="ingredient" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Ingredient name:</label>
            <@spring.formInput "ingredient.name", "name='nameInput' id='nameInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="currentAmountInput">Ingredient amount:</label>
            <@spring.formInput "ingredient.currentAmount", "name='currentAmountInput' id='currentAmountInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="priceInput">Ingredient price:</label>
            <@spring.formInput "ingredient.price", "name='priceInput' id='priceInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="expirationDateInput">Ingredient expiration date:</label>
            <@spring.formInput "ingredient.expirationDate", "name='expirationDateInput' id='expirationDateInput' required", "text"/>
        </div>

        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>