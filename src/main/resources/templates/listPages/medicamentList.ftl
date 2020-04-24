<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Medicament list</h1>

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
    </table>
</@c.wrapperWithCreateButton>