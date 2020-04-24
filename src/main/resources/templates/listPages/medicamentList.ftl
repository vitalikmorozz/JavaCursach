<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapper>
    <h1>Medicament list</h1>

    <form class="form-inline my-2 my-lg-0" method="get" action="/web/medicament/list">
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
            <th>Description</th>
            <th>Price</th>
            <th>Current Amount</th>
            <th>Minimum Amount</th>
            <th>Expiration Date</th>
            <th>Type</th>
            <th>Usage</th>
            <th>Creation Method</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#if sort == true>
            <#list medicaments?sort_by("name") as medicament>
                <tr>
                    <td>${medicament.name}</td>
                    <td>${medicament.description}</td>
                    <td>${medicament.price}</td>
                    <td>${medicament.currentAmount}</td>
                    <td>${medicament.minimalAmount}</td>
                    <td>${medicament.expirationDate}</td>
                    <td>${medicament.medicamentTypeId}</td>
                    <td>${medicament.medicamentUsageId}</td>
                    <td>${medicament.medicamentCreationId}</td>
                    <td><a href="delete/${medicament.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${medicament.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        <#else>
            <#list medicaments as medicament>
                <tr>
                    <td>${medicament.name}</td>
                    <td>${medicament.description}</td>
                    <td>${medicament.price}</td>
                    <td>${medicament.currentAmount}</td>
                    <td>${medicament.minimalAmount}</td>
                    <td>${medicament.expirationDate}</td>
                    <td>${medicament.medicamentTypeId}</td>
                    <td>${medicament.medicamentUsageId}</td>
                    <td>${medicament.medicamentCreationId}</td>
                    <td><a href="delete/${medicament.id}"><button class="btn btn-warning">Delete</button></a></td>
                    <td><a href="edit/${medicament.id}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
        </#if>


    </table>
    <a href="create"><button class="btn btn-primary">Create</button></a>

</@c.wrapper>