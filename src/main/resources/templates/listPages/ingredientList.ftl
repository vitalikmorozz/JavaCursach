<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Ingredients list</h1>

    <form class="form-inline my-2 my-lg-0" method="get" action="/web/ingredient/list">
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
            <th>Current amount</th>
            <th>Price</th>
            <th>Expiration date</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#if sort == true>
            <#list ingredients?sort_by("name") as ingredient>
                <tr>
                    <td>${ingredient.name}</td>
                    <td>${ingredient.currentAmount}</td>
                    <td>${ingredient.price}</td>
                    <td>${ingredient.expirationDate}</td>
                    <td><a href="delete/${ingredient.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${ingredient.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        <#else>
            <#list ingredients as ingredient>
                <tr>
                    <td>${ingredient.name}</td>
                    <td>${ingredient.currentAmount}</td>
                    <td>${ingredient.price}</td>
                    <td>${ingredient.expirationDate}</td>
                    <td><a href="delete/${ingredient.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${ingredient.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        </#if>


    </table>
    <a href="create"><button class="btn btn-primary">Create</button></a>

</@c.wrapper>