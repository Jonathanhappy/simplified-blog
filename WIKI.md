# Wiki du projet Simplified-Blog

## Acteurs du système :	

- Utilisateurs	

## Services :

- service d'authentification 
- Service de gestion du post
- Service de gestion des users
- service de gestion des commentaire

## Cas d'utilisation :	
- Un utilisateur peut créer un compte
- Un utilisateur peut créer un post
- Un utilisateur peut commenter un post	
- Un administrateur peut supprimer un compte
- Un utilisateur peut supprimer un post	
- Un utilisateur peut modifier son mot de passe ;	
- Un utilisateur peut modifier son nom d’utilisateur ;	
- Un utilisateur peut consulter son mot de passe ;
- Un utilisateur peut consulter son nom d’utilisateur ;	
- Un utilisateur peut supprimer son compte ;
- Un utilisateur peut modifier un post ;
- Un utilisateur peut enregistrer un post ;
- Un utilisateur peut consulter la liste des posts enregistrés ;	
- Un utilisateur peut signaler un post ;
- Un utilisateur peut consulter la liste des posts signalés ;
- Un utilisateur peut partager un post ;
- Un utilisateur peut consulter la liste des posts qu’il a déjà publié ;	
- Un utilisateur peut rechercher un post en fonction de la date ;	
- Un utilisateur peut rechercher un post en fonction des mots clés ;	
- Un utilisateur peut conserver un post (il le crée mais ne le publie pas) ;	
- Un utilisateur peut créer un post et programmer l’heure de sa publication ;	
- Un utilisateur peut bloquer un autre utilisateur ;	
- Un utilisateur peut consulter la liste des utilisateurs qu’il a bloqué ;	
- Un utilisateur peut modifier un commentaire ;	
- Un utilisateur peut supprimer un commentaire ;	
- Un utilisateur peut enregistrer un commentaire ;	
- Un utilisateur peut consulter la liste des commentaires enregistrés ;	
- Un utilisateur peut rechercher un commentaire en fonction de la date ;	
- Un utilisateur peut rechercher un commentaire en fonction des mots clés ;	
- Un utilisateur peut masquer un commentaire ;	
- Un utilisateur peut signaler un commentaire ;	
- Un utilisateur peut consulter la liste des commentaires signalés ;	
- Un utilisateur peut partager un commentaire ;	
- Un utilisateur peut répondre à un commentaire ;	
- Un utilisateur peut noter un commentaire ;

## API Design
### EndPoints
#### a - Utilisateur
- `/api/v1/users/create :` Endpoint permettant de créer un compte
- `/api/v1/users/get-all :` Retourner tous les utilisateurs
- `/api/v1/users/del/{user_id} :` Suppression d'un utilisateurs via son identifiant
- `/api/v1/users/get-password/{user_id} :` retourner le mot de passe
- `/api/v1/users/get-username/{user_id} :` retourner le nom d'utilisateur
- `/api/v1/users/block-user/{user_id} :` bloquer un utilisateur
- `/api/v1/users/reset-user/{user_id} :` Reinitialiser le nom d'utilisateur
- `/api/v1/users/reset-password/{user_id} :` Reinitialiser le mot de passe

#### b – Post
- `/api/v1/posts/create :` créer un post
- `/api/v1/posts/get-all :` retourne tous les posts crées
- `/api/v1/posts/del/{post_id} :` Suppression d'un post via son identifiant
- `/api/v1/posts/change-post/{post_id} :` modifier post via son identifiant
- `/api/v1/posts/save-post/{post_id} :` enregistrer post drafté
- `/api/v1/posts/get-all-post-saved :` retourne tous les posts enregistrés
- `/api/v1/posts/report-post/{post_id} :` signalé un post
- `/api/v1/posts/get-all-post-reported :` retourne tous les posts signalés
- `/api/v1/posts/share-post/{post_id}:` partager un post
- `/api/v1/posts/get-post-by-id/{post_id}:` retourne un post via son id
- `/api/v1/posts/get-post-by-date/{date}:` rechercher un post via la date
- `/api/v1/posts/get-post-by-keyword/{keyword}:` rechercher un post via mot clé
- `/api/v1/posts/draft-post:` enregistrer un post dans le brouillon
- `/api/v1/posts/get-all-posts-drafted:` retourne tous les posts enregistrés dans le brouillon
- `/api/v1/posts/publish-post:` programmer l'heure de publication d'un post

#### c – Commentaire
- `/api/v1/comments/add-comment-post/{post_id}:` l'utilisateur commente un post
- `/api/v1/comments/reply-comment/{comment_id}:` l'utilisateur répond à un commentaire
- `/api/v1/comments/change-comment/{comment_id}:` l'utilisateur modifie à un commentaire
- `/api/v1/comments/del-comment/{comment_id}:` l'utilisateur supprime un commentaire
- `/api/v1/comments/save-comment/{comment_id}:` l'utilisateur enregistre un commentaire
- `/api/v1/comments/hide-comment/{comment_id}:` masque un commentaire
- `/api/v1/comments/get-all-reply-comment:` retourne tous les commentaires enregistrés
- `/api/v1/comments/get-all-comments/{post_id}:` retourne tous les commentaires via post
- `/api/v1/comments/get-all-comments-by-date/{date}:` retourne tous les commentaires via date
- `/api/v1/comments/get-all-comments-by-keywords/{keywords}:` retourne tous les commentaires via mots clés
- `/api/v1/comments/report-comment/{comment_id}:` signalé un commentaire
- `/api/v1/comments/get-all-comments-reported` retourne tous les commentaires signalés
- `/api/v1/comments/share-comment/{comment_id}:` partager un commentaire
- `/api/v1/comments/report-comment/{comment_id}:` signaler un commentaire
- `/api/v1/comments/rate-comment/{comment_id}:` noter un commentaire

#### d - Authentification
- `/api/v1/auth/login :` Connexion d'un utilisateur au systeme
- `/api/v1/auth/logout :` Deconnexion du systeme
- `/api/v1/auth/reset-password :` Reinitialiser le mot de passe oublié
- `/api/v1/auth/reset-username :` Reinitialiser le nom d'utilisateur

## DataBase design

![MCD_simplifiedBlog.drawio.png](resources%2FMCD_simplifiedBlog.drawio.png)
