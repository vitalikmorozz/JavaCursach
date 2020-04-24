<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Ingredients list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Current amount</th>
            <th>Price</th>
            <th>Expiration date</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
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
    </table>
</@c.wrapperWithCreateButton>