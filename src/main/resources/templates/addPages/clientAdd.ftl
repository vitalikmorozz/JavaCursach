<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Clients editor</h1>
    <form name="client" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Client name:</label>
            <@spring.formInput "client.name", "name='nameInput' id='nameInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="ageInput">Client age:</label>
            <@spring.formInput "client.age", "name='ageInput' id='ageInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="addressInput">Client address:</label>
            <@spring.formInput "client.address", "name='addressInput' id='addressInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="phoneInput">Phone address:</label>
            <@spring.formInput "client.phone", "name='phoneInput' id='phoneInput' required", "text"/>
        </div>


        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>