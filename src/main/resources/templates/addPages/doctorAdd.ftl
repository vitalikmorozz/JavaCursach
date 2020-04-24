<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Doctors editor</h1>
    <form name="doctor" action="" method="POST">

        <div class="form-group">
            <label for="nameInput">Doctor name:</label>
            <@spring.formInput "doctor.name", "name='nameInput' id='nameInput' required", "text"/>
        </div>

        <div class="form-group">
            <label for="positionInput">Doctor position:</label>
            <@spring.formInput "doctor.position", "name='positionInput' id='positionInput' required", "text"/>
        </div>


        <button type="submit" class="btn btn-success">Confirm</button>
    </form>
</@c.wrapper>