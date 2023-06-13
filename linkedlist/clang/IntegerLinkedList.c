#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node
{
    int data;
    struct Node *next;
};

void traverse(struct Node *head);
void addFirst(struct Node **head_ref, int value);
void addLast(struct Node **head_ref, int value);
void addAfter(struct Node *prevNode, int value);
int getHead(struct Node *head);
int getTail(struct Node *head);
int getNodeByIndex(struct Node *head, int index);
void deleteFirst(struct Node **head_ref);
void deleteLast(struct Node **head_ref);
void deleteAtIndex(struct Node **head_ref, int index);
void deleteAfterNode(struct Node *prevNode);
void deleteByValue(struct Node **head_ref, int value);
void updateByIndex(struct Node **head_ref, int index, int value);

int main(int argc, char const *argv[])
{
    struct Node *head = NULL;
    struct Node *second = NULL;
    struct Node *third = NULL;
    struct Node *fourth = NULL;
    struct Node *fifth = NULL;

    head = (struct Node *)malloc(sizeof(struct Node));
    head->data = 3;

    second = (struct Node *)malloc(sizeof(struct Node));
    head->next = second;
    second->data = 4;

    third = (struct Node *)malloc(sizeof(struct Node));
    second->next = third;
    third->data = 5;

    fourth = (struct Node *)malloc(sizeof(struct Node));
    third->next = fourth;
    fourth->data = 6;

    fifth = (struct Node *)malloc(sizeof(struct Node));
    fourth->next = fifth;
    fifth->data = 7;

    printf("Traverse Linked List\n");
    traverse(head);

    addFirst(&head, 1);

    printf("\nLinked List after add 1 to first\n");
    traverse(head);

    addLast(&head, 8);

    printf("\nLinked List after add 8 to end\n");
    traverse(head);

    addAfter(head->next->next, 4);

    printf("\nLinked List after add 4 after the third\n");
    traverse(head);
    
    printf("\nHead of the linked list\n");
    printf("%d\n", getHead(head));

    printf("Tail of the linked list\n");
    printf("%d\n", getTail(head));

    printf("\nGet Node by index\n");
    printf("%d\n", getNodeByIndex(head, 5));

    deleteFirst(&head);

    printf("\nLinked List after delete first\n");
    traverse(head);

    deleteLast(&head);

    printf("\nLinked List after delete last\n");
    traverse(head);

    deleteAtIndex(&head, 2);

    printf("\nLinked List after delete at index 2\n");
    traverse(head);

    deleteAfterNode(head->next);

    printf("\nLinked List after delete after node\n");
    traverse(head);

    deleteByValue(&head, 4);

    printf("\nLinked List after delete by value\n");
    traverse(head);

    updateByIndex(&head, 2, 9);

    printf("\nLinked List after update by index\n");
    traverse(head);
    
    return 0;
}

/// @brief Traverse a linked list
/// @param head The head of the linked list
void traverse(struct Node *head)
{
    while (head != NULL)
    {
        printf("%d ", head->data);
        head = head->next;
    }
}

/// @brief Adds a node to the head of the linked list
/// @param head_ref The pointer to the linked list
/// @param value A value to add
void addFirst(struct Node **head_ref, int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));

    newNode->data = value;
    newNode->next = *head_ref;

    *head_ref = newNode;
}

/// @brief Adds a node to the end of the linked list
/// @param head_ref 
/// @param value 
void addLast(struct Node **head_ref, int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    struct Node *temp = *head_ref;

    newNode->data = value;
    newNode->next = NULL;

    if (*head_ref == NULL)
    {
        *head_ref = newNode;
        return;
    }

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = newNode;
}

/// @brief Adds a node after the given node
/// @param prevNode 
/// @param value 
void addAfter(struct Node *prevNode, int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));

    newNode->data = value;
    newNode->next = prevNode->next;

    prevNode->next = newNode;
}

/// @brief Get the first node in the list
/// @param head 
/// @return 
int getHead(struct Node *head)
{
    return head->data;
}

/// @brief Get the last node in the list
/// @param head the head node to get the list tail from the list
/// @return the value of the tail node
int getTail(struct Node *head)
{
    struct Node *temp = head;

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    return temp->data;
}

/// @brief Get a node by its index
/// @param index index of the node to retrieve
/// @return the value of the node to retrieve
int getNodeByIndex(struct Node *head, int index){
    struct Node *temp = head;

    for (int i = 0; i < index; i++)
    {
        temp = temp->next;
    }

    return temp->data;
}

/// @brief Delete the first node in the list
/// @param head the head node of the list to delete the head node
void deleteFirst(struct Node **head_ref)
{
    struct Node *temp = *head_ref;

    *head_ref = (*head_ref)->next;
    free(temp);
}

/// @brief Delete the last node in the list
/// @param head the head node of the list to delete the last node
void deleteLast(struct Node **head_ref)
{
    struct Node *temp = *head_ref;
    struct Node *prev = NULL;

    while (temp->next != NULL)
    {
        prev = temp;
        temp = temp->next;
    }

    prev->next = NULL;
    free(temp);
}

/// @brief Delete a node by its value
/// @param value the value to delete
void deleteByValue(struct Node **head_ref, int value)
{
    struct Node *temp = *head_ref;
    struct Node *prev = NULL;

    while (temp->data != value)
    {
        prev = temp;
        temp = temp->next;
    }

    prev->next = temp->next;
    free(temp);
}

/// @brief Delete a node by its index
/// @param index the index of the node to delete
void deleteAtIndex(struct Node **head_ref, int index)
{
    struct Node *temp = *head_ref;
    struct Node *prev = NULL;

    for (int i = 0; i < index; i++)
    {
        prev = temp;
        temp = temp->next;
    }

    prev->next = temp->next;
    free(temp);
}

/// @brief Update a node by its index
/// @param index the index of the node to update
/// @param value the new value to update
void updateByIndex(struct Node **head_ref, int index, int value)
{
    struct Node *temp = *head_ref;

    for (int i = 0; i < index; i++)
    {
        temp = temp->next;
    }

    temp->data = value;
}

/// @brief Delete a node after a specific node
/// @param head the head of the list to delete a node
void deleteAfterNode(struct Node *prevNode){
    struct Node *temp = prevNode->next;
    prevNode->next = temp->next;
    free(temp);
}