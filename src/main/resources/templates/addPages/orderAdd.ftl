<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Order editor</h1>
    <form name="order" action="" method="POST">

        <div class="form-group">
            <label for="typeInput">Order recipe:</label>
            <@spring.formSingleSelect "order.recipeId", recipes, "text"/>
        </div>

        <div class="form-group">
            <label for="nameInput">All ingredients available:</label>
            <@spring.formCheckbox "order.allIngredientsAvailable", ""/>
        </div>


        <div class="form-group">
            <label for="nameInput">Order ready:</label>
            <@spring.formCheckbox "order.ready", ""/>
        </div>


        <div class="form-group">
            <label for="nameInput">Order received:</label>
            <@spring.formCheckbox "order.received", ""/>
        </div>


        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>