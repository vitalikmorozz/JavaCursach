<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Clients list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list clients as client>
            <tr>
                <td>${client.name}</td>
                <td>${client.age}</td>
                <td>${client.address}</td>
                <td>${client.phone}</td>
                <td><a href="delete/${client.id}"><button class="btn btn-warning">Delete</button></a></td>
                <td><a href="edit/${client.id}"><button class="btn btn-info">Edit</button></a></td>
            </tr>
        </#list>
    </table>
</@c.wrapperWithCreateButton>