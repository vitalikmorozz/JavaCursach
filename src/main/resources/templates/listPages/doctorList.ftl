<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Doctors list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Position</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list doctors as doctor>
            <tr>
                <td>${doctor.name}</td>
                <td>${doctor.position}</td>
                <td><a href="delete/${doctor.id}"><button class="btn btn-warning">Delete</button></a></td>
                <td><a href="edit/${doctor.id}"><button class="btn btn-info">Edit</button></a></td>
            </tr>
        </#list>
    </table>
</@c.wrapperWithCreateButton>