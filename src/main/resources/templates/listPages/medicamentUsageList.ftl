<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Medicament Usages list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list medicamentUsages as medicamentUsage>
            <tr>
                <td>${medicamentUsage.name}</td>
                <td>${medicamentUsage.description}</td>
                <td><a href="delete/${medicamentUsage.id}"><button class="btn btn-warning">Delete</button></a></td>
                <td><a href="edit/${medicamentUsage.id}"><button class="btn btn-info">Edit</button></a></td>
            </tr>
        </#list>
    </table>
</@c.wrapperWithCreateButton>