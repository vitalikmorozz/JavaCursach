<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Order list</h1>

    <form class="form-inline my-2 my-lg-0" method="get" action="/web/order/list">
        <input class="form-control mr-sm-2" type="search" placeholder="Search by recipe id" aria-label="Search" name="filter" value="${filter}">
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
            <th>Recipe</th>
            <th>Is all ingredients available</th>
            <th>Id ready</th>
            <th>Id received</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#if sort == true>
            <#list orders?sort_by("recipeId") as order>
                <tr>
                    <td>${order.recipeId}</td>
                    <td>${order.allIngredientsAvailable?string('yes', 'no')}</td>
                    <td>${order.ready?string('yes', 'no')}</td>
                    <td>${order.received?string('yes', 'no')}</td>
                    <td><a href="delete/${order.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${order.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        <#else>
            <#list orders as order>
                <tr>
                    <td>${order.recipeId}</td>
                    <td>${order.allIngredientsAvailable?string('yes', 'no')}</td>
                    <td>${order.ready?string('yes', 'no')}</td>
                    <td>${order.received?string('yes', 'no')}</td>
                    <td><a href="delete/${order.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${order.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        </#if>

    </table>
    <a href="create"><button class="btn btn-primary">Create</button></a>

</@c.wrapper>