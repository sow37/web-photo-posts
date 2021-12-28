<c:import url="./Includes/header.jsp" />



<div class="message success">
    This is a message
</div>

<div class="container">


    <div style="text-align: center; font-size: 40px;">
        Liste des uttilisateurs
    </div>

    <table>
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
            <th>Login</th>
            <th>Statut</th>
            <th>Opérations</th>
        </tr>
        <c:forEach items="${ users }" var="user">
            <tr>
                <td>
                    <c:out value="${ user.nom }" />
                </td>
                <td>
                    <c:out value="${ user.prenom }" />
                </td>
                <td>
                    <c:out value="${ user.email }" />
                </td>
                <td>
                    <c:out value="${ user.compte.login }" />
                </td>
                <td>
                    <c:out value="${ user.statut == 'admin' ? 'Administrateur' : 'Utilisateur' }" />
                </td>
                <td>
                    <a href="<c:url value=" /user/update?user=${ user.id }" />">
                    </a>
                    <a
                        onclick="return confirm('Voulez-vous vraiment supprimer cet utilisateur ?');"
                        href="<c:url value=" /user/delete?user=${ user.id }" />">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>



<c:import url="./Includes/footer.jsp" />