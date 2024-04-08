/*
 * This file is generated by jOOQ.
 */

package edu.java.domain.jooq;

import edu.java.domain.jooq.tables.GithubLinks;
import edu.java.domain.jooq.tables.Links;
import edu.java.domain.jooq.tables.StackoverflowLinks;
import edu.java.domain.jooq.tables.TgChatLinks;
import edu.java.domain.jooq.tables.TgChats;
import edu.java.domain.jooq.tables.records.GithubLinksRecord;
import edu.java.domain.jooq.tables.records.LinksRecord;
import edu.java.domain.jooq.tables.records.StackoverflowLinksRecord;
import edu.java.domain.jooq.tables.records.TgChatLinksRecord;
import edu.java.domain.jooq.tables.records.TgChatsRecord;
import javax.annotation.processing.Generated;
import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes", "this-escape"})
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GithubLinksRecord> CONSTRAINT_3 = Internal.createUniqueKey(GithubLinks.GITHUB_LINKS,
        DSL.name("CONSTRAINT_3"),
        new TableField[] {GithubLinks.GITHUB_LINKS.ID},
        true
    );
    public static final UniqueKey<GithubLinksRecord> CONSTRAINT_3A = Internal.createUniqueKey(GithubLinks.GITHUB_LINKS,
        DSL.name("CONSTRAINT_3A"),
        new TableField[] {GithubLinks.GITHUB_LINKS.LINK_ID},
        true
    );
    public static final UniqueKey<LinksRecord> CONSTRAINT_4 =
        Internal.createUniqueKey(Links.LINKS, DSL.name("CONSTRAINT_4"), new TableField[] {Links.LINKS.ID}, true);
    public static final UniqueKey<LinksRecord> CONSTRAINT_45 =
        Internal.createUniqueKey(Links.LINKS, DSL.name("CONSTRAINT_45"), new TableField[] {Links.LINKS.URI}, true);
    public static final UniqueKey<StackoverflowLinksRecord> CONSTRAINT_1 =
        Internal.createUniqueKey(StackoverflowLinks.STACKOVERFLOW_LINKS,
            DSL.name("CONSTRAINT_1"),
            new TableField[] {StackoverflowLinks.STACKOVERFLOW_LINKS.ID},
            true
        );
    public static final UniqueKey<StackoverflowLinksRecord> CONSTRAINT_1C =
        Internal.createUniqueKey(StackoverflowLinks.STACKOVERFLOW_LINKS,
            DSL.name("CONSTRAINT_1C"),
            new TableField[] {StackoverflowLinks.STACKOVERFLOW_LINKS.LINK_ID},
            true
        );
    public static final UniqueKey<TgChatLinksRecord> CONSTRAINT_A = Internal.createUniqueKey(TgChatLinks.TG_CHAT_LINKS,
        DSL.name("CONSTRAINT_A"),
        new TableField[] {TgChatLinks.TG_CHAT_LINKS.ID},
        true
    );
    public static final UniqueKey<TgChatsRecord> CONSTRAINT_6 = Internal.createUniqueKey(TgChats.TG_CHATS,
        DSL.name("CONSTRAINT_6"),
        new TableField[] {TgChats.TG_CHATS.ID},
        true
    );
    public static final UniqueKey<TgChatsRecord> CONSTRAINT_67 = Internal.createUniqueKey(TgChats.TG_CHATS,
        DSL.name("CONSTRAINT_67"),
        new TableField[] {TgChats.TG_CHATS.CHAT_ID},
        true
    );

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<GithubLinksRecord, LinksRecord> CONSTRAINT_3A6 = Internal.createForeignKey(
        GithubLinks.GITHUB_LINKS,
        DSL.name("CONSTRAINT_3A6"),
        new TableField[] {GithubLinks.GITHUB_LINKS.LINK_ID},
        Keys.CONSTRAINT_4,
        new TableField[] {Links.LINKS.ID},
        true
    );
    public static final ForeignKey<StackoverflowLinksRecord, LinksRecord> CONSTRAINT_1CD = Internal.createForeignKey(
        StackoverflowLinks.STACKOVERFLOW_LINKS,
        DSL.name("CONSTRAINT_1CD"),
        new TableField[] {StackoverflowLinks.STACKOVERFLOW_LINKS.LINK_ID},
        Keys.CONSTRAINT_4,
        new TableField[] {Links.LINKS.ID},
        true
    );
    public static final ForeignKey<TgChatLinksRecord, TgChatsRecord> CONSTRAINT_AA = Internal.createForeignKey(
        TgChatLinks.TG_CHAT_LINKS,
        DSL.name("CONSTRAINT_AA"),
        new TableField[] {TgChatLinks.TG_CHAT_LINKS.TG_CHAT_ID},
        Keys.CONSTRAINT_6,
        new TableField[] {TgChats.TG_CHATS.ID},
        true
    );
    public static final ForeignKey<TgChatLinksRecord, LinksRecord> CONSTRAINT_AAB = Internal.createForeignKey(
        TgChatLinks.TG_CHAT_LINKS,
        DSL.name("CONSTRAINT_AAB"),
        new TableField[] {TgChatLinks.TG_CHAT_LINKS.LINK_ID},
        Keys.CONSTRAINT_4,
        new TableField[] {Links.LINKS.ID},
        true
    );
}