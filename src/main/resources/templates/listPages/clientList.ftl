<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Clients list</h1>

    <form class="form-inline my-2 my-lg-0" method="get" action="/web/client/list">
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
            <th>Age</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#if sort == true>
            <#list clients?sort_by("name") as client>
                <tr>
                    <td>${client.name}</td>
                    <td>${client.age}</td>
                    <td>${client.address}</td>
                    <td>${client.phone}</td>
                    <td><a href="delete/${client.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${client.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        <#else>
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
        </#if>


    </table>
    <a href="create"><button class="btn btn-primary">Create</button></a>


</@c.wrapper>