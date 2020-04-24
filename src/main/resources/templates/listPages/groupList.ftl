<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Groups list</h1>
    <table class="table">
        <tr class="thead-dark">
            <th>Name</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list groups?sort_by("name") as group>
        <tr>
            <td>${group.name}</td>
            <td>${group.description}</td>
            <td><a href="delete/${group.id}"><button class="btn btn-warning">Delete</button></a></td>
            <td><a href="edit/${group.id}"><button class="btn btn-info">Edit</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button class="btn btn-primary">Create</button></a>

</@c.wrapper>