<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Medicament Creations techniques list</h1>

    <form class="form-inline my-2 my-lg-0" method="get" action="/web/medicamentCreation/list">
        <input class="form-control mr-sm-2" type="search" placeholder="Search by name" aria-label="Search" name="filter" value="${filter}">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="sort" id="sortCheckbox" class="custom-control-input">
            <label class="custom-control-label" for="sortCheckbox">Sort</label>
        </div>
        <button style="margin-left: 10px" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <script>
        if(${sort?c}) document.getElementById("sortCheckbox").checked = "true";
    </script>
    <br>

    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Description</th>
            <th>Ingredient amount</th>
            <th>Ingredient</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#if sort == true>
            <#list medicamentCreations?sort_by("name") as medicamentCreation>
                <tr>
                    <td>${medicamentCreation.name}</td>
                    <td>${medicamentCreation.creationDescription}</td>
                    <td>${medicamentCreation.ingredientAmount}</td>
                    <td>${medicamentCreation.ingredientId}</td>
                    <td><a href="delete/${medicamentCreation.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${medicamentCreation.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        <#else>
            <#list medicamentCreations as medicamentCreation>
                <tr>
                    <td>${medicamentCreation.name}</td>
                    <td>${medicamentCreation.creationDescription}</td>
                    <td>${medicamentCreation.ingredientAmount}</td>
                    <td>${medicamentCreation.ingredientId}</td>
                    <td><a href="delete/${medicamentCreation.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${medicamentCreation.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        </#if>

    </table>
    <a href="create"><button class="btn btn-primary">Create</button></a>

</@c.wrapper>