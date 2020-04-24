<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Order Archive editor</h1>
    <form name="orderArchive" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Order id:</label>
            <@spring.formSingleSelect "orderArchive.orderId", orders, "text"/>
        </div>

        <div class="form-group">
            <label for="descriptionInput">Receive date:</label>
            <@spring.formInput "orderArchive.receiveDate", "name='descriptionInput' id='descriptionInput' required", "text"/>
        </div>

        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>