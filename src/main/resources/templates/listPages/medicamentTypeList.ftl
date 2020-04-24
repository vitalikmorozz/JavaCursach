<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Medicament Types list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list medicamentTypes as medicamentType>
            <tr>
                <td>${medicamentType.name}</td>
                <td>${medicamentType.description}</td>
                <td><a href="delete/${medicamentType.id}"><button class="btn btn-warning">Delete</button></a></td>
                <td><a href="edit/${medicamentType.id}"><button class="btn btn-info">Edit</button></a></td>
            </tr>
        </#list>
    </table>
</@c.wrapperWithCreateButton>