<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Recipes list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Doctor</th>
            <th>Client</th>
            <th>Diagnosis</th>
            <th>Medicament</th>
            <th>Medicament amount</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list recipes as recipe>
            <tr>
                <td>${recipe.doctorId}</td>
                <td>${recipe.clientId}</td>
                <td>${recipe.diagnosis}</td>
                <td>${recipe.medicamentId}</td>
                <td>${recipe.medicamentAmount}</td>
                <td><a href="delete/${recipe.id}"><button class="btn btn-warning">Delete</button></a></td>
                <td><a href="edit/${recipe.id}"><button class="btn btn-info">Edit</button></a></td>
            </tr>
        </#list>
    </table>
</@c.wrapperWithCreateButton>