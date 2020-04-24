<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Order list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Recipe</th>
            <th>Is all ingredients available</th>
            <th>Id ready</th>
            <th>Id received</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
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
    </table>
</@c.wrapperWithCreateButton>