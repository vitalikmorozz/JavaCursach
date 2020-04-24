<#import "/spring.ftl" as spring/>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
        <h1>Group editor</h1>
        <form name="group" action="" method="POST">
<#--            <div class="form-row">-->
                <div class="form-group">
                    <label for="nameInput">Group name:</label>
                    <@spring.formInput "group.name", "name='nameInput' id='nameInput' required", "text"/>
                </div>
                <div class="form-group">
                    <label for="descriptionInput">Group description:</label>
                    <@spring.formInput "group.description", "name='escriptionInput' id='descriptionInput' required", "text"/>
                </div>
<#--            </div>-->
            <button type="submit" class="btn btn-success">Confirm</button>
        </form>
</@c.wrapper>