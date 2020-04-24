<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Medicament Creations techniques list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Description</th>
            <th>Ingredient amount</th>
            <th>Ingredient</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
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
    </table>
</@c.wrapperWithCreateButton>