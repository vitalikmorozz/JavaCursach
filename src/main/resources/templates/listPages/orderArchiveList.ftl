<#import "/spring.ftl" as spring>
<#import "../parts/common.ftl" as c>

<@c.wrapperWithCreateButton>
    <h1>Order Archive list</h1>

    <table class="table">
        <tr class="thead-dark">
            <th>Order</th>
            <th>Receive date</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list orderArchives as orderArchive>
            <tr>
                <td>${orderArchive.orderId}</td>
                <td>${orderArchive.receiveDate}</td>
                <td><a href="delete/${orderArchive.id}"><button class="btn btn-warning">Delete</button></a></td>
                <td><a href="edit/${orderArchive.id}"><button class="btn btn-info">Edit</button></a></td>
            </tr>
        </#list>
    </table>
</@c.wrapperWithCreateButton>